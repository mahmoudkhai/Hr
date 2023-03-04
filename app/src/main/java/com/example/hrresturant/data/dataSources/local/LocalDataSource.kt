package com.example.hrresturant.data.dataSources.local

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: Dao) {

    //    private val dao = db.daoInstance()
    fun getItemByCategory(category: String): Flow<List<Meal?>?> {
        Log.d(
            "Repository",
            "Dao returned ${dao.fetchItemsByCategory(category).asLiveData().value} "
        )
        return dao.fetchItemsByCategory(category)
    }



    fun getTopRatedItems(): Flow<List<Meal?>?> {
        return dao.getTopRatedMeals()
    }

    suspend fun addItems(list: List<Meal?>?) {
        Log.d("Repository", "Trying to cache $list")
        dao.insertItems(list)
    }

    suspend fun addItem(item: Meal?) {
        Log.d("Repository", "Trying to cache ${item?.id} ${item?.title}")
        withContext(Dispatchers.IO) {
            dao.insertItem(item)
        }
    }

    suspend fun deleteAllItems() = dao.deleteItems()
    fun isRoomEmpty(): LiveData<List<Meal?>?> = dao.getAllItems()
//
//    suspend fun addItemToFavourite(id: Int?) = dao.addItemToFavourite(id)
//
//    suspend fun removeItemFromFavourite(id: Int?) = dao.removeItemFromFavourite(id)


//    fun getFavouriteItems(): Flow<List<ItemEntity>?> = dao.getFavouriteItems()

}