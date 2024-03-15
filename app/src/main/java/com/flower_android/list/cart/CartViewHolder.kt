package com.flower_android.list.cart

import android.graphics.Bitmap
import androidx.recyclerview.widget.RecyclerView
import com.flower_android.databinding.ItemCartBinding
import com.flower_android.model.ImageProvider
import com.flower_android.model.OrderItem

class CartViewHolder(
    private val binding: ItemCartBinding,
    private val itemHandler: CartItemHandler? = null
) : RecyclerView.ViewHolder(binding.root), ImageProvider.Callback {

    fun bind(item: OrderItem) {
        binding.item = item
        item.img_name?.let { ImageProvider(this).getImage(it) }
        binding.minusButton.setOnClickListener {
            val count = binding.countTextView.text.toString().toInt()
            if (count > 1) {
                binding.countTextView.text = "${count - 1}"
                binding.priceTextView.text = "${item.menu_price!! * (count - 1)}원"
                itemHandler?.minus(count - 1, item.id!!)
            }
        }
        binding.plusButton.setOnClickListener {
            val count = binding.countTextView.text.toString().toInt()
            if (count < 9) {
                binding.countTextView.text = "${count + 1}"
                binding.priceTextView.text = "${item.menu_price!! * (count + 1)}원"
                itemHandler?.plus(count + 1, item.id!!)
            }
        }
        binding.deleteButton.setOnClickListener {
            itemHandler?.delete(item)
        }
    }

    override fun getImage(bitmap: Bitmap) {
        binding.imageView.setImageBitmap(bitmap)
    }
}