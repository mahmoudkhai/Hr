package com.example.hrresturant.ui.fragment.bottomNav.sweets

import android.os.Bundle
import android.view.View
import com.example.hrresturant.data.BurgerEntity
import com.example.hrresturant.data.CommonInterface
import com.example.hrresturant.databinding.FragmentSweetsBinding
import com.example.hrresturant.ui.adapter.SweetAdapter
import com.example.hrresturant.ui.adapter.VerticalPagerAdapter
import com.example.hrresturant.ui.fragment.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class SweetsFragment: BaseFragment<FragmentSweetsBinding>(FragmentSweetsBinding::inflate)  {

    private lateinit var pagerAdapter: VerticalPagerAdapter
    private val tabs = listOf("HotDesserts", "Waffles", "IceCream")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val general = listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))
        val croissant =
            listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))
        val omelette =
            listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))
        val pancake = listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))

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
    private fun createListOfAdapters(vararg list: List<CommonInterface>): List<SweetAdapter> =
        list.map {
            SweetAdapter(it)
        }
}