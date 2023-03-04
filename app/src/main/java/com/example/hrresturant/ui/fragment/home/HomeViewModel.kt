package com.example.hrresturant.ui.fragment.home

import androidx.lifecycle.*
import com.example.hrresturant.data.dataSources.local.Meal
import com.example.hrresturant.data.repositories.BaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val baseRepository: BaseRepository
) : ViewModel() {

    val topRated = baseRepository.getTopRated().asLiveData()
    val mostPopular = baseRepository.getMostPopular().asLiveData()
    init {
        topRated
        mostPopular
    }



}