package com.flower_android.list

import android.util.Log
import com.flower_android.model.MenuItem


interface ItemHandler {
    fun onClickItem(item: MenuItem)
}