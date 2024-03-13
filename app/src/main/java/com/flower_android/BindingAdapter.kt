package com.flower_android

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.flower_android.model.ImageItem

@BindingAdapter("price")
fun TextView.setPrice(price: Int) {
    text = "${price}원"
}