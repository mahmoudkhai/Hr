package com.example.hrresturant.data.dataSources

import com.google.gson.annotations.SerializedName

class GeneralEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("estimatedTime")
    val estimatedTime: Double,
)
