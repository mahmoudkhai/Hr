package com.example.hrresturant.ui.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.hrresturant.R
import com.example.hrresturant.databinding.FragmentHomeBinding
import com.example.hrresturant.ui.adapter.HorizentalAdapter
import com.example.hrresturant.ui.adapter.ItemListener
import com.example.hrresturant.ui.adapter.VerticalAdapter
import com.example.hrresturant.ui.base.BaseFragment
import com.example.hrresturant.ui.util.NetworkResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate), ItemListener {
    private val homeViewModel: HomeViewModel by viewModels<HomeViewModel>()

    private val offersAdapter: HorizentalAdapter by lazy {
        HorizentalAdapter(
            this,
            requireContext(),
            emptyList()
        )
    }
    private val mostPopularAdapter: VerticalAdapter by lazy {
        VerticalAdapter(this, requireContext(), emptyList())
    }
    private val topRatedAdapter: VerticalAdapter by lazy {
        VerticalAdapter(this, requireContext(), emptyList())
    }
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = NavHostFragment.findNavController(this)
        binding.recyclarViewOffers.adapter = offersAdapter
        binding.recyclarViewMostPopular.adapter = mostPopularAdapter
        setOnClickViews()
        homeViewModel.topRated.observe(viewLifecycleOwner) {
            it.let {
                topRatedAdapter.setNewData(it!!)
            }
        }
        homeViewModel.mostPopular.observe(viewLifecycleOwner) {
            it.let {
                mostPopularAdapter.setNewData(it!!)
            }
        }

//        findNavController()

    }

    override fun addItemToFavourite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
//            homeViewModel.addItemToFavorite(id)
        }
    }

    override fun removeItemFromFavourite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
//            homeViewModel.removeItemFromFavorite(id)
        }
    }

    private fun setOnClickViews() {
        binding.breakfastImg.setOnClickListener {
            hideBottomNav()
            navController.navigate(R.id.breakfastFragment)
        }
        binding.lunchImg.setOnClickListener {
            hideBottomNav()
            navController.navigate(R.id.lunchFragment)
        }
        binding.dessertImg.setOnClickListener {
            hideBottomNav()
            navController.navigate(R.id.sweetsFragment)
        }
        binding.drinksImg.setOnClickListener {
            hideBottomNav()
            navController.navigate(R.id.drinksFragment)
        }
    }

    private fun hideBottomNav() {
        activity?.findViewById<View>(R.id.bottomNavigation)?.visibility = View.GONE
    }
}