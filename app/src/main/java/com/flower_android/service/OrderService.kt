package com.flower_android.service

import com.flower_android.model.OrderItem
import com.flower_android.model.OrderResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface OrderService {

    @POST("api/order")
    fun order(@Body requestBody: OrderItem) : Call<OrderResponse>

    @GET("api/order/cartId")
    fun getOrderId() : Call<OrderResponse>
}