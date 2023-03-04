package com.example.hrresturant.data.dataSources.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromCroissantList(value: List<Meal>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Meal>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCroissantList(value: String): List<Meal> {
        val gson = Gson()
        val type = object : TypeToken<List<Meal>>() {}.type
        return gson.fromJson(value, type)
    }
}