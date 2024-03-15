package com.flower_android.util

import android.content.Context
import android.content.SharedPreferences
import com.flower_android.model.OrderItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PreferenceUtil(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("order", Context.MODE_PRIVATE)

    fun getOrder(key: String, defValue: String): OrderItem? {
        val json = preferences.getString(key, defValue)
        json?.let {
            val gson = Gson()
            val type = object : TypeToken<OrderItem>() {}.type
            return gson.fromJson(json, type)
        }
        return null
    }

    fun setOrder(key: String, orderItem: OrderItem) {
        val gson = Gson()
        val json = gson.toJson(orderItem)
        preferences.edit().putString(key, json).apply()
    }

    fun getAllOrders(): MutableList<OrderItem> {
        val orderList = mutableListOf<OrderItem>()
        val gson = Gson()
        val type = object : TypeToken<OrderItem>() {}.type
        for ((key, value) in preferences.all) {
            val order = gson.fromJson<OrderItem>(value as String, type)
            orderList.add(order)
        }

        return orderList
    }

    fun refresh() {
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }

    fun deleteOrder(id : Int) {
        preferences.edit().remove(id.toString()).apply()
    }
}