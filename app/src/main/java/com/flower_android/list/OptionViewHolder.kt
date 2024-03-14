package com.flower_android.list

import androidx.recyclerview.widget.RecyclerView
import com.flower_android.databinding.ItemOptionBinding
import com.flower_android.model.CommonItem

class OptionViewHolder(
    private val binding : ItemOptionBinding,
    private val itemHandler: ItemHandler? =null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : CommonItem) {
        binding.item = item
    }
}