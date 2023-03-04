package com.example.hrresturant.ui.fragment.home.drinks

import com.example.hrresturant.data.dataSources.local.Meal
import com.example.hrresturant.databinding.FragmentDrinksBinding
import com.example.hrresturant.ui.adapter.ItemListener
import com.example.hrresturant.ui.adapter.VerticalAdapter
import com.example.hrresturant.ui.adapter.VerticalPagerAdapter
import com.example.hrresturant.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrinksFragment : BaseFragment<FragmentDrinksBinding>(FragmentDrinksBinding::inflate),
    ItemListener {

    private lateinit var pagerAdapter: VerticalPagerAdapter
    private val tabs = listOf(
        "Hot Drinks",
        "Turkish Coffee",
        "Strong Coffee",
        "Classic Coffee",
        "Medium Coffee",
        "Milk Shakes",
        "Fresh Juices",
        "Iced Coffee",
        "Frappueeino",
        "Cocktails",
        "Smoothies",
        "Yogurt"
    )

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val general = listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))
//        val croissant =
//            listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))
//        val omelette =
//            listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))
//        val pancake = listOf(BurgerEntity("KK", "HH", 42.0, 32), BurgerEntity("KK", "fdf", 3.4, 32))
//
//        pagerAdapter = VerticalPagerAdapter(
//            createListOfAdapters(
//                general, croissant, omelette, pancake
//            )
//        )
//
//        binding.viewPager.adapter = pagerAdapter
//        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
//            tab.text = tabs[position]
//        }.attach()
//
//    }
    private fun createListOfAdapters(vararg list: List<Meal>): List<VerticalAdapter> =
        list.map {
            VerticalAdapter(this , requireContext(),emptyList())
        }

    override fun addItemToFavourite(id: Int) {
        TODO("Not yet implemented")
    }

    override fun removeItemFromFavourite(id: Int) {
        TODO("Not yet implemented")
    }

}