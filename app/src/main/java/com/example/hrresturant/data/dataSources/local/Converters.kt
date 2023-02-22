package com.example.hrresturant.data.dataSources.local

import androidx.room.TypeConverter
import com.example.hrresturant.data.dataSources.CroissantEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromCroissantList(value: List<CroissantEntity>): String {
        val gson = Gson()
        val type = object : TypeToken<List<CroissantEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCroissantList(value: String): List<CroissantEntity> {
        val gson = Gson()
        val type = object : TypeToken<List<CroissantEntity>>() {}.type
        return gson.fromJson(value, type)
    }
}