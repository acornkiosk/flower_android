package com.flower_android.service

import com.flower_android.model.MenuItem
import com.flower_android.model.MenuListResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MenuService {

    @POST("menu/list")
    fun getMenu(@Body requestBody:MenuItem): Call<MenuListResponse>
}