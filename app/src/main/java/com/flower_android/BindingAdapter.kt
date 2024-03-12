package com.flower_android

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("price")
fun TextView.setPrice(price:Int) {
    text = "${price}원"
}