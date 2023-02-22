package com.example.hrresturant.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater , container: ViewGroup? , boolean:Boolean) -> VB
) : Fragment() {

     private var _binding: VB? =null
    val binding: VB
     get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater , container , false)
        if (_binding == null) {
            throw  java.lang.IllegalArgumentException("Binding cannot be null")
        }
        return binding.root
    }


}