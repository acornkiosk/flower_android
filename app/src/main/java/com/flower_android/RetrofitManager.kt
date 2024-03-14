package com.flower_android

import com.flower_android.service.MenuService
import com.flower_android.service.OptionService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://flower.onleave.co.kr:9000/flower/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()


    val menuService: MenuService by lazy { retrofit.create(MenuService::class.java) }

    val optionService: OptionService by lazy { retrofit.create(OptionService::class.java) }
}