package com.flower_android

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.flower_android.model.OrderItem

@BindingAdapter("price")
fun TextView.setPrice(price: Int) {
    text = "${price}원"
}

@BindingAdapter("total")
fun TextView.setTotal(item : OrderItem) {
    text = "${item.menu_price!! * item.menu_count!!}원"
}

@BindingAdapter("options")
fun TextView.setOptions(options: String) {
    text = if (options == "") {
        "옵션 없음"
    } else {
        options.dropLast(2)
    }
}

@BindingAdapter("count")
fun TextView.setCount(count : Int) {
    text = "$count"
}

@BindingAdapter("image")
fun ImageView.setImage(code_img: String) {
    when (code_img) {
        "image1.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image1))
        }

        "image2.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image2))
        }

        "image3.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image3))
        }

        "image4.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image4))
        }

        "image5.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image5))
        }

        "image6.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image6))
        }

        "image7.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image7))
        }

        "image8.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image8))
        }

        "image9.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image9))
        }

        "image10.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image10))
        }

        "image11.png" -> {
            setImageDrawable(resources.getDrawable(R.drawable.image11))
        }
    }

}