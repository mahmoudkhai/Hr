package com.example.hrresturant.ui.fragment.bottomNav.breakfast

import android.os.Bundle
import android.view.View
import com.example.hrresturant.data.BurgerEntity
import com.example.hrresturant.data.CommonInterface
import com.example.hrresturant.databinding.FragmentBreakfastBinding
import com.example.hrresturant.ui.adapter.BreakfastAdapter
import com.example.hrresturant.ui.adapter.HorizentalPagerAdapter
import com.example.hrresturant.ui.fragment.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class BreakfastFragment :
    BaseFragment<FragmentBreakfastBinding>(FragmentBreakfastBinding::inflate) {
    private lateinit var breakfastPagerAdapter: HorizentalPagerAdapter
    private val tabs = listOf("general", "Croissant", "Omelette", "Pancake")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val general = listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))
        val croissant =
            listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))
        val omelette =
            listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))
        val pancake = listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))

        breakfastPagerAdapter = HorizentalPagerAdapter(
            createListOfAdapters(
                general, croissant, omelette, pancake
            )
        )

        binding.viewPager.adapter = breakfastPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabs[position]
        }.attach()

    }
    private fun createListOfAdapters(vararg list: List<CommonInterface>): List<BreakfastAdapter> =
        list.map {
            BreakfastAdapter(it)
        }



}