package com.example.hrresturant.ui.fragment.drawer

import android.os.Bundle
import android.view.View
import com.example.hrresturant.databinding.FragmentAboutDeveloperBinding
import com.example.hrresturant.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutDeveloperFragment :
    BaseFragment<FragmentAboutDeveloperBinding>(FragmentAboutDeveloperBinding::inflate){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}