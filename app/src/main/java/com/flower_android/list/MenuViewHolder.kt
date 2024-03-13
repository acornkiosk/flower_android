package com.flower_android.list

import android.graphics.Bitmap
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.flower_android.databinding.ItemMenuBinding
import com.flower_android.model.ImageProvider
import com.flower_android.model.MenuItem

class MenuViewHolder(
    private val binding: ItemMenuBinding,
    private val itemHandler: ItemHandler? = null
) : RecyclerView.ViewHolder(binding.root), ImageProvider.Callback {

    fun bind(item: MenuItem) {
        binding.item = item
        binding.handler = itemHandler
        item.img_name?.let { ImageProvider(this).getImage(it) }
    }

    override fun getImage(bitmap: Bitmap) {
        binding.imageView.setImageBitmap(bitmap)
    }
}