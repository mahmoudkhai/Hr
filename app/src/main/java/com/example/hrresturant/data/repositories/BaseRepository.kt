package com.example.hrresturant.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.hrresturant.data.dataSources.local.Meal
import com.example.hrresturant.data.dataSources.local.LocalDataSource
import com.example.hrresturant.data.dataSources.remote.RemoteDataSource
import com.example.hrresturant.ui.util.NetworkResponse
import com.example.hrresturant.ui.util.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BaseRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {


    fun isRoomEmpty(): LiveData<List<Meal?>?> = localDataSource.isRoomEmpty()

    fun getDataFromNetworkAndCacheIt() = flow<UiState> {
        emit(UiState.Loading)
        when (val dataFromNetwork = remoteDataSource.getDataFromNetwork()) {
            is NetworkResponse.Success -> {
                withContext(Dispatchers.IO) {
                    localDataSource.addItems(dataFromNetwork.data?.items)
                }
                emit(UiState.Success)
            }
            is NetworkResponse.Error -> emit(UiState.Error(dataFromNetwork.errorMessage))
        }
    }
//
//    suspend fun <T> getDataFromInternetAndCacheIt(): NetworkResponse<T> {
//        try {
//            Log.d("Repository", "getDataFromInternetAndCacheIt")
//            withContext(Dispatchers.IO) {
//                val result = remoteDataSource.getDataFromNetwork()
//                result?.forEach { meal ->
//                    localDataSource.addItem(meal)
//                }
//            }
//            Log.d("Repository", "cached successfully")
//            return true
//        } catch (e: Exception) {
//            Log.d("Repository", "getDataFromInternet: Failed ${e.message}")
//        }
//        return false
//    }

    //Home page
    fun getTopRated(): Flow<List<Meal?>?> =
        localDataSource.getTopRatedItems()


    fun getMostPopular(): Flow<List<Meal?>?> =
        localDataSource.getItemByCategory("mostPopular")


    // Breakfast
    fun getCroissant(): Flow<List<Meal?>?> {
        return localDataSource.getItemByCategory("croissant ")
    }

    fun getGeneral(): Flow<List<Meal?>?> {
        return localDataSource.getItemByCategory("general")
    }

    //
    fun getOmelette(): Flow<List<Meal?>?> {
        return localDataSource.getItemByCategory("omelette")
    }

    fun getPancake(): Flow<List<Meal?>?> = localDataSource.getItemByCategory("pancake")
//
//    //Lunch Fragment
//    fun getSoup(): Flow<List<Meal>> = localDataSource.getItemByCategory("soup")
//    fun getAppetizers(): Flow<List<Meal>> = localDataSource.getItemByCategory("appetizers")
//    fun getSalades(): Flow<List<Meal>> = localDataSource.getItemByCategory("salade")
//    fun getBurger(): Flow<List<Meal>> = localDataSource.getItemByCategory("burger")
//    fun getSandwiches(): Flow<List<Meal>> = localDataSource.getItemByCategory("sandwiches")
//    fun getPasta(): Flow<List<Meal>> = localDataSource.getItemByCategory("pasta")
//    fun getPizza(): Flow<List<Meal>> = localDataSource.getItemByCategory("pizza")
//    fun getChicken(): Flow<List<Meal>> = localDataSource.getItemByCategory("chicken")
//    fun getBeef(): Flow<List<Meal>> = localDataSource.getItemByCategory("beef")
//    fun getMixDishes(): Flow<List<Meal>> = localDataSource.getItemByCategory("mixDishes")
//    fun getSeaFood(): Flow<List<Meal>> = localDataSource.getItemByCategory("seaFood")
//    fun getSauces(): Flow<List<Meal>> = localDataSource.getItemByCategory("sauces")
//    fun getRibEyeSteak(): Flow<List<Meal>> = localDataSource.getItemByCategory("ribEyeSteak")
//    fun getFajitaDishes(): Flow<List<Meal>> =
//        localDataSource.getItemByCategory("fajitaDishes")
//
//    fun getSideDishes(): Flow<List<Meal>> = localDataSource.getItemByCategory("sideDishes")

    // Favourite Fragment
//    fun getFavouriteItems(): Flow<List<Meal>?> = localDataSource.getFavouriteItems()

    //    suspend fun addItemToFavourite(id: Int) {
//        coroutineScope {
//            localDataSource.addItemToFavourite(id)
//        }
//    }
    //    suspend fun removeItemFromFavourite(id: Int) {
//        coroutineScope { localDataSource.removeItemFromFavourite(id) }
//    }
}
