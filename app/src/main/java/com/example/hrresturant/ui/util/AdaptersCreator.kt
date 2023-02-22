package com.example.hrresturant.ui.util

import com.example.hrresturant.data.CommonInterface
import com.example.hrresturant.ui.adapter.SweetAdapter

class  AdaptersCreator {

    fun createListOfAdapters(vararg list: List<CommonInterface>): List<SweetAdapter> =
        list.map {
            SweetAdapter(it)
        }
}