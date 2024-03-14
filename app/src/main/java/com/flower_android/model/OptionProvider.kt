package com.flower_android.model

import com.flower_android.RetrofitManager
import retrofit2.Call
import retrofit2.Response

class OptionProvider(private val callback: Callback) {

    fun getOption(code_id: Int,type:String?) {
        val commonItem = CommonItem(code_id = code_id)
        RetrofitManager.optionService.getOption(commonItem)
            .enqueue(object : retrofit2.Callback<CommonResponse> {
                override fun onResponse(
                    call: Call<CommonResponse>,
                    response: Response<CommonResponse>
                ) {
                    if (response.isSuccessful) {
                        val list = mutableListOf<CommonItem>()
                        response.body()?.let {
                            callback.getOption(it.list,type)
                        }
                    }
                }

                override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

    interface Callback {
        fun getOption(list: List<CommonItem>, type : String? = null)
    }
}