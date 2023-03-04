package com.example.hrresturant.ui.fragment.bottomNav.favourite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.example.hrresturant.data.dataSources.CommonInterface
import com.example.hrresturant.data.dataSources.local.ItemEntity
import com.example.hrresturant.databinding.FragmentFavouriteBinding
import com.example.hrresturant.ui.adapter.HorizentalAdapter
import com.example.hrresturant.ui.adapter.ItemListener
import com.example.hrresturant.ui.fragment.BaseFragment
import com.example.hrresturant.ui.fragment.bottomNav.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavouriteFragment :
    BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate), ItemListener {
    private val favouriteViewModel: FavouriteViewModel by viewModels()
    private val favouriteAdapter: HorizentalAdapter by lazy {
        HorizentalAdapter(this , requireContext() , emptyList())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        items.observe(viewLifecycleOwner){
//            favouriteAdapter = HorizentalAdapter(this, requireContext(), it.toList())
//            binding.favouriteRecyclar.adapter = favouriteAdapter
//        }
        favouriteViewModel.favouriteItems.observe(viewLifecycleOwner){
            favouriteAdapter.setNewData(it)
        }
    }
    override fun addItemToFavourite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteViewModel.addItemToFavorite(id)
        }
    }

    override fun removeItemFromFavourite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            favouriteViewModel.removeItemFromFavorite(id)
        }
    }





}