package com.flower_android.service

import com.flower_android.model.ImageItem
import com.flower_android.model.MenuItem
import com.flower_android.model.MenuListResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MenuService {

    @POST("api/menu/list")
    fun getMenu(@Body requestBody: MenuItem): Call<MenuListResponse>

    @POST("upload/images")
    fun getImage(@Body requestBody: ImageItem): Call<ResponseBody>
}