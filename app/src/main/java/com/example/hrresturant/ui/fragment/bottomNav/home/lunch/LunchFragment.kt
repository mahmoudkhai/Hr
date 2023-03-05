package com.example.hrresturant.ui.fragment.bottomNav.home.lunch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.hrresturant.data.dataSources.CommonInterface
import com.example.hrresturant.data.dataSources.local.ItemEntity
import com.example.hrresturant.databinding.FragmentLunchBinding
import com.example.hrresturant.ui.adapter.HorizentalAdapter
import com.example.hrresturant.ui.adapter.HorizentalPagerAdapter
import com.example.hrresturant.ui.adapter.ItemListener
import com.example.hrresturant.ui.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LunchFragment : BaseFragment<FragmentLunchBinding>(FragmentLunchBinding::inflate),
    ItemListener {
    private val lunchViewModel:LunchViewModel by viewModels()
    private lateinit var pagerAdapter: HorizentalPagerAdapter
    private val tabs =
        listOf(
            "Soup",
            "Appetizers",
            "Salade",
            "Burger",
            "Sandwiches",
            "Pasta",
            "Pizza",
            "Chicken",
            "Beef",
            "Mix Dishes",
            "Rib Eye Steak",
            "Seafood",
            "Fajita dishes",
            "Side Dishes",
            "Sauces"
        )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
val context = requireContext()
//        val pizzaMeals =
//            listOf<PizzaEntity>(
//                PizzaEntity("MM", "HH", 42.0, 12),
//                PizzaEntity("MM", "fdf", 3.4, 18)
//            )
//        val soupMeals =
//            listOf<SoupEntity>(SoupEntity("KK", "HH", 42.0, 12), SoupEntity("KK", "fdf", 3.4, 18))
//        val burgerMeals =
//            listOf(BurgerEntity("KK", "HH", 42.0, 12), BurgerEntity("KK", "fdf", 3.4, 18))
//        val pastaMeals =
//            listOf(BurgerEntity("KK", "HH", 42.0, 12), BurgerEntity("KK", "fdf", 3.4, 18))
//        val saladeMeals =
//            listOf(BurgerEntity("KK", "HH", 42.0, 12), BurgerEntity("KK", "fdf", 3.4, 18))
//        val appetizersMeals =
//            listOf(BurgerEntity("KK", "HH", 42.0, 12), BurgerEntity("KK", "fdf", 3.4, 18))
//        val sandwiches =
//            listOf(BurgerEntity("KK", "HH", 42.0, 12), BurgerEntity("KK", "fdf", 3.4, 18))

//        pagerAdapter = HorizentalPagerAdapter(
//            createListOfAdapters(
//                pizzaMeals,
//                soupMeals,
//                burgerMeals,
//                saladeMeals,
//                pastaMeals,
//                sandwiches,
//                appetizersMeals
//            )
//        )
//        binding.viewPager.adapter = pagerAdapter
//        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
//            tab.text = tabs[position]
//        }.attach()
//
    }
    private fun createListOfAdapters(vararg list: List<ItemEntity>): List<HorizentalAdapter> =
        list.map {
            HorizentalAdapter(this , requireContext() ,it)
        }

    override fun addItemToFavourite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            lunchViewModel.addItemToFavorite(id)
        }
    }

    override fun removeItemFromFavourite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            lunchViewModel.removeItemFromFavorite(id)
        }
    }


}