package com.example.hrresturant.ui.fragment.home.breakfast

import androidx.lifecycle.*
import com.example.hrresturant.data.repositories.BaseRepository
import com.example.hrresturant.data.dataSources.local.Meal
import com.example.hrresturant.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BreakfastViewModel @Inject constructor(
    private val baseRepository: BaseRepository
) : BaseViewModel(baseRepository) {

    var croissant = baseRepository.getCroissant().asLiveData()
    var general = baseRepository.getGeneral().asLiveData()
    var pancake = baseRepository.getPancake().asLiveData()
    var omelette = baseRepository.getOmelette().asLiveData()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
            }
        }
    }


}