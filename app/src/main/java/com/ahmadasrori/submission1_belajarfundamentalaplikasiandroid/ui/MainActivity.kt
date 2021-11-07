package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.ui

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.adapter.SearchAdapter
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.ActivityMainBinding
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.search.Search
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()
    private val listUser = ArrayList<Search>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initList()
        observe()
        initListener()
    }

    private fun observe(){
        viewModel.search.observe(this, {
            listUser.clear()
            it.let {
                listUser.addAll(it)
                initList()
            }
        })
    }

    private fun initListener() {
        binding.etSearch.setOnEditorActionListener { v, actionId, event ->
            var handled = false
            if (EditorInfo.IME_ACTION_DONE == actionId || EditorInfo.IME_ACTION_UNSPECIFIED == actionId) {
                viewModel.search(v.text.toString())
                handled = true
            }
            handled
        }
    }

    private fun initList() {
        val adapter = SearchAdapter(this, listUser) {
            val intent = Intent(this@MainActivity, UserDetailActivity::class.java)
            intent.putExtra(UserDetailActivity.EXTRA_PERSON, listUser[it])
            startActivity(intent)
        }
        binding.rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvItem.adapter = adapter
    }

}