package com.flower_android.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OrderResponse(
    @SerializedName("dto") val item : OrderItem,
    @SerializedName("list") val list: List<OrderItem>,
    @SerializedName("status") val status : String
)

data class OrderItem(
    @SerializedName("order_id") var order_id : Int? = 0,
    @SerializedName("id") var id : Int? =0,
    @SerializedName("kiosk_id") val kiosk_id : Int? = 1,
    @SerializedName("menu_name") var menu_name : String? = "",
    @SerializedName("menu_price") var menu_price : Int? = 0,
    @SerializedName("menu_count") var menu_count : Int? = 1,
    @SerializedName("options") var options : String? = "",
    var optionsText : String? = "",
    var img_name : String? = ""
) : Serializable
