package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.R
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.adapter.SectionsPagerAdapter
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.ActivityUserDetailBinding
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.search.Search
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.viewmodel.MainViewModel
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.viewmodel.ext.android.viewModel

class UserDetailActivity : AppCompatActivity() {

    private val binding: ActivityUserDetailBinding by lazy {
        ActivityUserDetailBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()
    private var username: String? = ""

    companion object {
        const val EXTRA_PERSON = "extra_person"
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_follower,
            R.string.tab_following
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        observe()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        val user = intent.getParcelableExtra<Search>(EXTRA_PERSON) as Search
        username = user.login
        viewModel.getUserDetail(user.login)
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }

    @SuppressLint("SetTextI18n")
    private fun observe(){
        viewModel.userDetail.observe(this, {
            it.let {
                binding.tvName.text = it.name
                binding.tvUsername.text = it.login
                binding.tvRepository.text = "Repository : ${it.public_repos}"
                binding.tvFollower.text = "Follower : ${it.follower}"
                binding.tvFollowing.text = "Following : ${it.following}"
                binding.tvCompany.text = it.company
                binding.tvLocation.text = it.location
                Glide.with(this)
                    .load(it.avatar_url)
                    .circleCrop()
                    .into(binding.ivProfile)
            }
        })
    }

    fun sendData(): String? {
        return username
    }
}