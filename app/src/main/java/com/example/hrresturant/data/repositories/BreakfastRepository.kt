package com.example.hrresturant.data.repositories

import android.util.Log
import com.example.hrresturant.data.dataSources.local.ItemEntity
import com.example.hrresturant.data.dataSources.local.DatabaseDao
import com.example.hrresturant.data.dataSources.remote.HrApi
import com.example.hrresturant.ui.util.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BreakfastRepository(private val api: HrApi, private val dao: DatabaseDao) {

    private val items =
        listOf(
            ItemEntity(
                2,
                "Soup", "HH",
                42.0,
                "32",
                "croissant", "", false
            ),
            ItemEntity(
                1,
                "croissant", "HH",
                50.0,
                "32",
                "croissant", "", false
            ),
            ItemEntity(
                3,
                "Pizza", "HH",
                42.0,
                "32",
                "pancake", "", false
            ),
            ItemEntity(
                4,
                "Pasta", "HH",
                42.0,
                "32",
                "omelette", "", false
            ),
        )
}