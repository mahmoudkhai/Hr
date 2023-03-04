package com.example.hrresturant.ui.fragment.home.sweets

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.hrresturant.databinding.FragmentSweetsBinding
import com.example.hrresturant.ui.adapter.HorizentalAdapter
import com.example.hrresturant.ui.adapter.ItemListener
import com.example.hrresturant.ui.adapter.VerticalPagerAdapter
import com.example.hrresturant.ui.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@AndroidEntryPoint
class SweetsFragment : BaseFragment<FragmentSweetsBinding>(FragmentSweetsBinding::inflate),
    ItemListener {

    private lateinit var pagerAdapter: VerticalPagerAdapter
    private val sweetsViewModel: SweetsViewModel by viewModels()
    private val tabs = listOf("HotDesserts", "Waffles", "IceCream")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        pagerAdapter = VerticalPagerAdapter(
            createListOfAdapters(
                3
            )
        )

        binding.viewPager.adapter = pagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabs[position]
        }.attach()

    }

    private fun createListOfAdapters(numberOfAdapters:Int): List<HorizentalAdapter> {
        val listOfAdapters = mutableListOf<HorizentalAdapter>()
        for (i in 0 until numberOfAdapters) {
            listOfAdapters.add(HorizentalAdapter(this, requireContext(), emptyList()))
        }
        return listOfAdapters

    }


    override fun addItemToFavourite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            sweetsViewModel.addItemToFavorite(id)
        }
    }

    override fun removeItemFromFavourite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            sweetsViewModel.removeItemFromFavorite(id)
        }
    }
}