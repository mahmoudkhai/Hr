package com.example.hrresturant.ui.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.hrresturant.data.repositories.BaseRepository
import com.example.hrresturant.ui.util.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
open class BaseViewModel @Inject constructor(private val baseRepository: BaseRepository) :
    ViewModel() {

    fun addItemToFavorite(id: Int) {
//        viewModelScope.launch {
//            baseRepository.addItemToFavourite(id)
//        }
    }

    fun removeItemFromFavorite(id: Int) {
//        viewModelScope.launch {
//            baseRepository.removeItemFromFavourite(id)
//        }
    }





}