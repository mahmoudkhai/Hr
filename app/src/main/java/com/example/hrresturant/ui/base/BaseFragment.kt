package com.example.hrresturant.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.example.hrresturant.ui.adapter.ItemListener
import com.example.hrresturant.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, boolean: Boolean) -> VB
) : Fragment() {
    private val baseViewModel: BaseViewModel by viewModels()

    private var _binding: VB? = null
    val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = bindingInflater.invoke(inflater, container, false)
        if (_binding == null) {
            throw  java.lang.IllegalArgumentException("Binding cannot be null")
        }
        return binding.root
    }


}