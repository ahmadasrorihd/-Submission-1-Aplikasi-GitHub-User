package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.ActivityUserDetailBinding
import com.bumptech.glide.Glide

class UserDetailActivity : AppCompatActivity() {

    private val binding: ActivityUserDetailBinding by lazy {
        ActivityUserDetailBinding.inflate(layoutInflater)
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        val user = intent.getParcelableExtra<UserData>(EXTRA_PERSON) as UserData
        binding.tvName.text = user.name
        binding.tvUsername.text = user.username
        binding.tvRepository.text = "Repository : ${user.repository}"
        binding.tvFollower.text = "Follower : ${user.follower}"
        binding.tvFollowing.text = "Following : ${user.following}"
        binding.tvCompany.text = user.company
        binding.tvLocation.text = user.location
        Glide.with(this)
            .load(getImage(user.avatar))
            .circleCrop()
            .into(binding.ivProfile)
    }

    fun getImage(imageName: String?): Int {
        return resources.getIdentifier(imageName, "drawable", packageName)
    }
}