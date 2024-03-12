package com.flower_android.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.flower_android.databinding.ItemMenuBinding
import com.flower_android.model.MenuItem

class MenuAdapter(private val itemHandler: ItemHandler? = null) :
    ListAdapter<MenuItem, MenuViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MenuViewHolder(ItemMenuBinding.inflate(inflater, parent, false), itemHandler)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MenuItem>() {
            override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
                return oldItem == newItem
            }

        }
    }


}