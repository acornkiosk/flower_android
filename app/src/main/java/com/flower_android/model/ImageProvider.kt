package com.flower_android.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.flower_android.RetrofitManager
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class ImageProvider(private val callback: Callback) {

    fun getImage(name: String) {
        val imageItem = ImageItem(name = name)
        RetrofitManager.menuService.getImage(imageItem)
            .enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        val bitmap = BitmapFactory.decodeStream(response.body()!!.byteStream())
                        callback.getImage(bitmap)
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    t.printStackTrace()
                }

            })
    }

    interface Callback {
        fun getImage(bitmap: Bitmap)
    }
}