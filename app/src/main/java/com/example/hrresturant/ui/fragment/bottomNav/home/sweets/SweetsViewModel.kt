package com.example.hrresturant.ui.fragment.bottomNav.home.sweets

import androidx.lifecycle.ViewModel
import com.example.hrresturant.data.repositories.BaseRepository
import com.example.hrresturant.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class SweetsViewModel @Inject constructor (private val baseRepository: BaseRepository): BaseViewModel(baseRepository) {


}