package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.adapter.UserAdapter
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.FragmentFollowingBinding
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.User
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FollowingFragment : Fragment() {
    private val binding: FragmentFollowingBinding by lazy {
        FragmentFollowingBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()
    private val listItem = ArrayList<User>()
    private var username: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initView()
        observe()
        return binding.root
    }

    private fun initView() {
        val activity: UserDetailActivity? = activity as UserDetailActivity?
        username = activity?.sendData()
        viewModel.getFollowing(username)
    }

    private fun observe(){
        viewModel.following.observe(viewLifecycleOwner, {
            listItem.clear()
            it.let {
                listItem.addAll(it)
                initList()
            }
        })
    }

    private fun initList() {
        val adapter = UserAdapter(requireActivity(), listItem) {
        }
        binding.rvItem.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvItem.adapter = adapter
    }
}