package com.example.hrresturant.ui.fragment.favourite

import com.example.hrresturant.data.repositories.BaseRepository
import com.example.hrresturant.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor (private val baseRepository: BaseRepository) : BaseViewModel(baseRepository) {

//    var favouriteItems: LiveData<List<ItemEntity>> = baseRepository.getFavouriteItems().asLiveData()

    init {
//        favouriteItems
    }


}