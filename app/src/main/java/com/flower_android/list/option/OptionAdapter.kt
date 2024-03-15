package com.flower_android.list.option

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flower_android.databinding.ItemOptionBinding
import com.flower_android.model.CommonItem

class OptionAdapter(private val itemHandler: OptionItemHandler? = null, private val recyclerView: RecyclerView) :
    ListAdapter<CommonItem, OptionViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return OptionViewHolder(ItemOptionBinding.inflate(inflater, parent, false), recyclerView,itemHandler)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.bind(currentList[position],position)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<CommonItem>() {
            override fun areItemsTheSame(oldItem: CommonItem, newItem: CommonItem): Boolean {
                return oldItem.code_id == newItem.code_id
            }

            override fun areContentsTheSame(oldItem: CommonItem, newItem: CommonItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}