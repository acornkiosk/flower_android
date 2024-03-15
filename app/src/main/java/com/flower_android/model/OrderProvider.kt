package com.flower_android.model

import com.flower_android.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderProvider(private val callback: Callback) {
    fun order(orderItem: OrderItem) {
        RetrofitManager.orderService.order(orderItem)
            .enqueue(object : retrofit2.Callback<OrderResponse> {
                override fun onResponse(
                    call: Call<OrderResponse>,
                    response: Response<OrderResponse>
                ) {
                    if(response.isSuccessful){
                        callback.order(true)
                    }
                }

                override fun onFailure(call: Call<OrderResponse>, t: Throwable) {
                    callback.order(false)
                }


            })
    }

    fun getOrderId() {
        RetrofitManager.orderService.getOrderId()
            .enqueue(object : retrofit2.Callback<OrderResponse>{
                override fun onResponse(
                    call: Call<OrderResponse>,
                    response: Response<OrderResponse>
                ) {
                    if(response.isSuccessful){
                        callback.getOrderId(response.body()!!.item.order_id!!)
                    }
                }

                override fun onFailure(call: Call<OrderResponse>, t: Throwable) {
                    t.printStackTrace()
                }


            })
    }

    interface Callback {
        fun order(isSuccess: Boolean)

        fun getOrderId(order_id:Int)
    }
}