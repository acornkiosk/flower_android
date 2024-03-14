package com.flower_android.service

import com.flower_android.model.CommonItem
import com.flower_android.model.CommonResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface OptionService {

    @POST("api/common/child")
    fun getOption(@Body requestBody: CommonItem): Call<CommonResponse>
}