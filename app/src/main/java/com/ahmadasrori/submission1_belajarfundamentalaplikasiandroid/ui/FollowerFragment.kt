package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.adapter.UserAdapter
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.FragmentFollowerBinding
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.User
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FollowerFragment : Fragment() {
    private val binding: FragmentFollowerBinding by lazy {
        FragmentFollowerBinding.inflate(layoutInflater)
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
        viewModel.getFollower(username)
        binding.pgBar.visibility = View.VISIBLE
    }

    private fun observe(){
        viewModel.follower.observe(viewLifecycleOwner, {
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
        binding.pgBar.visibility = View.GONE
    }
}