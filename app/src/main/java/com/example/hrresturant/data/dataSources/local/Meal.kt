package com.example.hrresturant.data.dataSources.local

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Meal(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    @SerializedName("name")
    val title: String?,
    @SerializedName("description")
    val description: String?,
//    @SerializedName("image")
//    var itemImage: String? = "fgf",
    @SerializedName("time")
    val estimatedTime: String?,
//    @SerializedName("price")
//    var price: Double? = 3.45,
    @SerializedName("category")
    val category: String?,
    @SerializedName("topRated")
    val topRated: Int?
    //    val isChecked: Boolean?
):java.io.Serializable
