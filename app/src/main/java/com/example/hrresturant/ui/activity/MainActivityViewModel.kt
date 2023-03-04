package com.example.hrresturant.ui.activity

import androidx.lifecycle.*
import com.example.hrresturant.data.repositories.BaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val baseRepository: BaseRepository) :
    ViewModel() {
    var status = baseRepository.getDataFromNetworkAndCacheIt().asLiveData()
    var _status = baseRepository.isRoomEmpty()


//    fun getDataFromInternetAndCacheIt() {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                baseRepository.getDataFromNetworkAndCacheIt()
//            }
//        }
//    }
}