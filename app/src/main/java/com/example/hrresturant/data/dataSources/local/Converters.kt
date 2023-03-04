package com.example.hrresturant.data.dataSources.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromCroissantList(value: List<ItemEntity>): String {
        val gson = Gson()
        val type = object : TypeToken<List<ItemEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCroissantList(value: String): List<ItemEntity> {
        val gson = Gson()
        val type = object : TypeToken<List<ItemEntity>>() {}.type
        return gson.fromJson(value, type)
    }
}