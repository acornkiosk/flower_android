package com.flower_android.list

import androidx.recyclerview.widget.RecyclerView
import com.flower_android.databinding.ItemMenuBinding
import com.flower_android.model.MenuItem

class MenuViewHolder(
    private val binding: ItemMenuBinding,
    private val itemHandler: ItemHandler? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : MenuItem) {
        binding.item = item
        binding.handler = itemHandler
    }

}