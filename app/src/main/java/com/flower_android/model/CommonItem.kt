package com.flower_android.model

import com.google.gson.annotations.SerializedName

data class CommonResponse(
    @SerializedName("dto") val item: CommonItem,
    @SerializedName("list") val list: List<CommonItem>,
    @SerializedName("status") val status: String
)

data class CommonItem(
    @SerializedName("code_id") val code_id: Int? = 0,
    @SerializedName("p_code_id") val p_code_id: Int? = 0,
    @SerializedName("code_name") val code_name: String? = "",
    @SerializedName("code_value") val code_value: String? = "",
    @SerializedName("code_img") val code_img: String? = ""
)
