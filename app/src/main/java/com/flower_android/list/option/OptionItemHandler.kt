package com.flower_android.list.option

import com.flower_android.model.CommonItem

interface OptionItemHandler {

    fun onClickItem(item: CommonItem, checked :Boolean)
}