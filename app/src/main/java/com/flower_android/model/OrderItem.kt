package com.flower_android.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OrderItem(
    @SerializedName("order_id") val order_id : Int? = 0,
    @SerializedName("id") val id : Int? =0,
    @SerializedName("kiosk_id") val kiosk_id : Int? = 1,
    @SerializedName("menu_name") var menu_name : String? = "",
    @SerializedName("menu_price") val menu_price : Int? = 0,
    @SerializedName("menu_count") var menu_count : Int? = 1,
    @SerializedName("options") var options : String? = "",
    var optionsText : String? = ""
) : Serializable
