package com.example.hrresturant.ui.fragment.bottomNav.home.breakfast

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import com.example.hrresturant.R
import com.example.hrresturant.data.dataSources.CommonInterface
import com.example.hrresturant.data.dataSources.local.ItemEntity
import com.example.hrresturant.databinding.FragmentBreakfastBinding
import com.example.hrresturant.ui.adapter.HorizentalAdapter
import com.example.hrresturant.ui.adapter.HorizentalPagerAdapter
import com.example.hrresturant.ui.adapter.ItemListener
import com.example.hrresturant.ui.fragment.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BreakfastFragment :
    BaseFragment<FragmentBreakfastBinding>(FragmentBreakfastBinding::inflate), ItemListener {
    private lateinit var breakfastPagerAdapter: HorizentalPagerAdapter
    private val breakfastViewModel: BreakfastViewModel by viewModels()
    private val tabs = listOf("general", "Croissant", "Omelette", "Pancake")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val icons =
            listOf(
                ResourcesCompat.getDrawable(resources, R.drawable.drinks, null),
                ResourcesCompat.getDrawable(resources, R.drawable.dessert, null),
                ResourcesCompat.getDrawable(resources, R.drawable.eggs_and_toast, null),
                ResourcesCompat.getDrawable(resources, R.drawable.facebook, null),
            )

        val listOfAdapters = createListOfAdapters(4)
        breakfastPagerAdapter = HorizentalPagerAdapter(
            listOfAdapters
        )
        binding.viewPager.adapter = breakfastPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabs[position]
            tab.icon = icons[position]
        }.attach()
        breakfastViewModel.croissant.observe(viewLifecycleOwner) {
            listOfAdapters[1].setNewData(it)
            it.forEach { Log.d("Repository", "Recieved ${it.title}") }
        }
//        viewModel.getBreakfast().observe(viewLifecycleOwner) {
//            when (it) {
//                is NetworkResponse.Loading -> {
//                    hideErrorLayout()
//                    showLoading()
//                }
//                is NetworkResponse.Failure -> {
//                    hideLoading()
//                    showErrorLayout()
//                }
//                is NetworkResponse.Success -> {
//                    hideLoading()
//                    hideErrorLayout()
//                    HorizentalPagerAdapter(
//                        createListOfAdapters(
//                            it.data!!.croissant,
//                            it.data.general,
//                            it.data.omelette,
//                            it.data.panCake
//                        )
//                    )
//                }
//            }
//        }


    }

    private fun createListOfAdapters(numberOfAdapters: Int): List<HorizentalAdapter> {
        val listOfAdapters = mutableListOf<HorizentalAdapter>()
        for (i in 0 until 4) {
            listOfAdapters.add(HorizentalAdapter(this, requireContext(), emptyList()))
        }
        return listOfAdapters

    }

    private fun showLoading() {
        binding.loading.progressBar.visibility = View.VISIBLE
    }

    private fun hideErrorLayout() {
        binding.error.errorImg.visibility = View.GONE
        binding.error.errorText.visibility = View.GONE
    }

    private fun showErrorLayout() {
        binding.error.errorImg.visibility = View.VISIBLE
        binding.error.errorText.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.loading.progressBar.visibility = View.GONE
    }

    override fun addItemToFavourite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            breakfastViewModel.addItemToFavorite(id)
        }
    }

    override fun removeItemFromFavourite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            breakfastViewModel.removeItemFromFavorite(id)
        }
    }
}

