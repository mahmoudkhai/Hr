package com.example.hrresturant.ui.adapter

import com.example.hrresturant.ui.base.BaseListener

interface ItemListener : BaseListener {
    fun addItemToFavourite(id: Int)
    fun removeItemFromFavourite(id: Int)
}