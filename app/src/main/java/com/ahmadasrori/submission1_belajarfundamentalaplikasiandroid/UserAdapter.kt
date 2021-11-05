package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.UserItemBinding
import com.bumptech.glide.Glide

class UserAdapter (
    private val activity: Activity,
    private val items: List<UserData>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<UserAdapter.ItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.user_item,
            parent,
            false
        ) as UserItemBinding
        return ItemVH(viewBinding)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        val item = items[position]
        holder.binding.item = item
        Glide.with(activity).load(getImage(item.avatar)).into(holder.binding.ivProfile)
        holder.binding.cardItem.setOnClickListener {
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

    fun getImage(imageName: String?): Int {
        return activity.getResources().getIdentifier(imageName, "drawable", activity.packageName)
    }

}