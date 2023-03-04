package com.example.hrresturant.data.dataSources.remote

import com.example.hrresturant.data.dataSources.local.Meal
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("breakfast")
    val items:List<Meal?>?,

    )
