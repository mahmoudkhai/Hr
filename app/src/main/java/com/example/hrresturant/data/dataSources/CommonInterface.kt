package com.example.hrresturant.data.dataSources

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

abstract class CommonInterface(
    open val id:Int,
    open val title: String,
    open val description: String,
    open val price: Double,
    open val estimatedTime: String,
    open val itemImage: String,
    open var isChecked: Boolean
)
