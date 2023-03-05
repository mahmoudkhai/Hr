package com.example.hrresturant.ui.fragment.bottomNav.home.sweets

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.hrresturant.data.dataSources.CommonInterface
import com.example.hrresturant.data.dataSources.local.ItemEntity
import com.example.hrresturant.databinding.FragmentSweetsBinding
import com.example.hrresturant.ui.adapter.HorizentalAdapter
import com.example.hrresturant.ui.adapter.ItemListener
import com.example.hrresturant.ui.adapter.VerticalAdapter
import com.example.hrresturant.ui.adapter.VerticalPagerAdapter
import com.example.hrresturant.ui.fragment.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@AndroidEntryPoint
class SweetsFragment : BaseFragment<FragmentSweetsBinding>(FragmentSweetsBinding::inflate), ItemListener {

    private lateinit var pagerAdapter: VerticalPagerAdapter
    private val sweetsViewModel:SweetsViewModel by viewModels()
    private val tabs = listOf("HotDesserts", "Waffles", "IceCream")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val general = listOf(
            ItemEntity(
                1, "True", "HH", 42.0, "32 M", "hghdf", "hghg", false
            ),
            ItemEntity(2, "Burger", "fdf", 3.4, "32 M", "hghdf", "hghg", false),
            ItemEntity(3, "Burger", "fdf", 3.4, "32 M", "hghdf", "hghg", false),
            ItemEntity(4, "Pizza", "fdf", 3.4, "32 M", "hghdf", "hghg", false)
        )
        val croissant =
            listOf(
                ItemEntity(
                    1, "True", "HH", 42.0, "32 M", "hghdf", "hghg", false
                ),
                ItemEntity(2, "Burger", "fdf", 3.4, "32 M", "hghdf", "hghg", false),
                ItemEntity(3, "Burger", "fdf", 3.4, "32 M", "hghdf", "hghg", false),
                ItemEntity(4, "Pizza", "fdf", 3.4, "32 M", "hghdf", "hghg", false)
            )
        val omelette =
            listOf(
                ItemEntity(
                    1, "True", "HH", 42.0, "32 M", "hghdf", "hghg", false
                ),
                ItemEntity(2, "Burger", "fdf", 3.4, "32 M", "hghdf", "hghg", false),
                ItemEntity(3, "Burger", "fdf", 3.4, "32 M", "hghdf", "hghg", false),
                ItemEntity(4, "Pizza", "fdf", 3.4, "32 M", "hghdf", "hghg", false)
            )
        val pancake = listOf(
            ItemEntity(
                1, "True", "HH", 42.0, "32 M", "hghdf", "hghg", false
            ),
            ItemEntity(2, "Burger", "fdf", 3.4, "32 M", "hghdf", "hghg", false),
            ItemEntity(3, "Burger", "fdf", 3.4, "32 M", "hghdf", "hghg", false),
            ItemEntity(4, "Pizza", "fdf", 3.4, "32 M", "hghdf", "hghg", false)
        )

        pagerAdapter = VerticalPagerAdapter(
            createListOfAdapters(
                general, croissant, omelette
            )
        )

        binding.viewPager.adapter = pagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabs[position]
        }.attach()

    }

    private fun createListOfAdapters(vararg list: List<ItemEntity>): List<HorizentalAdapter> =
        list.map {
            HorizentalAdapter(this , requireContext() ,it)
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