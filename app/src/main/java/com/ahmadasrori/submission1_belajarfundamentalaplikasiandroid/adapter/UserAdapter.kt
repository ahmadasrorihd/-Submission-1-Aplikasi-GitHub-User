package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.UserItemBinding
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.User
import com.bumptech.glide.Glide

class UserAdapter (
    private val activity: Activity,
    private val items: List<User>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<UserAdapter.ItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemVH(binding)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = items[position]
        holder.binding.tvNama.text = item.login
        Glide.with(activity).load(item.avatar_url).into(holder.binding.ivProfile)
        holder.binding.layoutItem.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemVH(mainBinding: UserItemBinding) :
        RecyclerView.ViewHolder(mainBinding.root) {
        val binding = mainBinding
    }

}