package com.flower_android.list.cart

import com.flower_android.model.OrderItem

interface CartItemHandler {

    fun minus(count : Int, id: Int)

    fun plus(count : Int, id: Int)

    fun delete(item : OrderItem)
}