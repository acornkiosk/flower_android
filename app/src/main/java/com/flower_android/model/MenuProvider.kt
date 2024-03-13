package com.flower_android.model

import com.flower_android.RetrofitManager
import retrofit2.Call
import retrofit2.Response

class MenuProvider(private val callback: Callback) {
    fun getMenu(categoryId: Int) {
        val menuItem = MenuItem(category_id = categoryId)
        RetrofitManager.menuService.getMenu(menuItem)
            .enqueue(object : retrofit2.Callback<MenuListResponse> {
                override fun onResponse(
                    call: Call<MenuListResponse>,
                    response: Response<MenuListResponse>
                ) {
                    if (response.isSuccessful) {
                        val list = mutableListOf<MenuItem>()
                        response.body()?.let {
                            if (response.isSuccessful) {
                                callback.getMenuList(it.list)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MenuListResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }

    interface Callback {
        fun getMenuList(list: List<MenuItem>)
    }
}