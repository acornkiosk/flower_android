package com.flower_android.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MenuListResponse(
    @SerializedName("dto") val dto: MenuItem,
    @SerializedName("list") val list: List<MenuItem>,
    @SerializedName("status") val status : String
)

data class MenuItem(
    @SerializedName("id") val id: Int? = 0,
    @SerializedName("name") val name: String? = "",
    @SerializedName("price") val price: Int? = 0,
    @SerializedName("img_name") val img_name: String? = "",
    @SerializedName("summary") val summary: String? ="",
    @SerializedName("description") val description: String? = "",
    @SerializedName("is_sold") val isSold: String? = "false",
    @SerializedName("category_id") val category_id: Int? = 0,
    var count : Int? = 0
) : Serializable
