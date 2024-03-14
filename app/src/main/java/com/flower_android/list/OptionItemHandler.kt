package com.flower_android.list

import com.flower_android.model.CommonItem

interface OptionItemHandler {

    fun onClickItem(item: CommonItem,position: Int)
}