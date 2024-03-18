package com.flower_android.list.option

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.flower_android.databinding.ItemOptionBinding
import com.flower_android.model.CommonItem

class OptionViewHolder(
    private val binding: ItemOptionBinding,
    private val recyclerView: RecyclerView,
    private val itemHandler: OptionItemHandler? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CommonItem, position: Int) {
        binding.item = item
        binding.handler = itemHandler
        binding.root.setOnClickListener {
            if (item.p_code_id == 2012) {
                binding.checkImageView.isVisible = !binding.checkImageView.isVisible
            } else {
                for (i in 0 until recyclerView.childCount) {
                    val childView = recyclerView.getChildAt(i)
                    val viewHolder = recyclerView.getChildViewHolder(childView)
                    if (viewHolder is OptionViewHolder) {
                        viewHolder.binding.checkImageView.isVisible = false
                    }
                }
                binding.checkImageView.isVisible = true
            }
            itemHandler?.onClickItem(item, binding.checkImageView.isVisible)
        }
    }
}