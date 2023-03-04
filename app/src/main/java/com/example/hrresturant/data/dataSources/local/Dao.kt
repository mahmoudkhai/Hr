package com.example.hrresturant.data.dataSources.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Query("Select * From meal WHERE category = :category")
    fun fetchItemsByCategory(category: String): Flow<List<Meal?>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Meal?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(list: List<Meal?>?)

    @Query ("Select * from meal")
    fun getAllItems():LiveData<List<Meal?>?>

    @Query("Select * from meal where topRated = 1")
    fun getTopRatedMeals():Flow<List<Meal?>?>
    /***
     * favourite is the status to be updated
     */
//    @Query("UPDATE 'table' SET isChecked = 1 WHERE id = :id")
//    suspend fun addItemToFavourite(id: Int?)
//
//    @Query("UPDATE `table` SET isChecked = 0 WHERE id = :id")
//    suspend fun removeItemFromFavourite(id: Int?)

    @Query("DELETE FROM meal")
    suspend fun deleteItems()

//    @Query("SELECT * FROM `table` WHERE isChecked = 1")
//    fun getFavouriteItems(): Flow<List<ItemEntity>?>
//
//    @Query("DELETE FROM Tasks WHERE completed = 1")
//    suspend fun deleteCompletedTasks(): Int
//    @Query("DELETE FROM Tasks WHERE entryid = :taskId")
//    suspend fun deleteTaskById(taskId: String): Int


}