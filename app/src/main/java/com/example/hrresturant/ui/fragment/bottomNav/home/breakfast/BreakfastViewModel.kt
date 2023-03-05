package com.example.hrresturant.ui.fragment.bottomNav.home.breakfast

import androidx.lifecycle.*
import com.example.hrresturant.data.repositories.BaseRepository
import com.example.hrresturant.data.dataSources.local.ItemEntity
import com.example.hrresturant.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class BreakfastViewModel @Inject constructor (
    private val baseRepository: BaseRepository
) : BaseViewModel(baseRepository) {

    var croissant: LiveData<List<ItemEntity>> = baseRepository.getCroissant().asLiveData()
    var general: LiveData<List<ItemEntity>> = baseRepository.getGeneral().asLiveData()
    var pancake: LiveData<List<ItemEntity>> = baseRepository.getPancake().asLiveData()
    var omelette: LiveData<List<ItemEntity>> = baseRepository.getOmelette().asLiveData()



}