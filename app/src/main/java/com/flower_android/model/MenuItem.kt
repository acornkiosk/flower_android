package com.flower_android.model

import com.google.gson.annotations.SerializedName

data class MenuListResponse(
    val list : List<MenuItem>
)
data class MenuItem(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("price") val price : Int,
    @SerializedName("img_name") val imgName : String,
    @SerializedName("summary") val summary : String,
    @SerializedName("description") val description : String,
    @SerializedName("is_sold") val isSold : Boolean,
    @SerializedName("category_id") val categoryId : Int
)
