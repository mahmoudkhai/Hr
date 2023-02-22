package com.example.hrresturant.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hrresturant.databinding.FragmentAboutDeveloperBinding
import com.example.hrresturant.databinding.FragmentAboutRestaurantBinding
import com.example.hrresturant.databinding.RestaurantImageItemBinding
import com.example.hrresturant.databinding.VerticalViewPagerItemBinding
import com.example.hrresturant.ui.adapter.base.PolyMorphism
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter (private val images : List<Int>):
    RecyclerView.Adapter<SliderAdapter.ViewPagerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = RestaurantImageItemBinding.inflate(LayoutInflater.from(parent.context) , parent, false)
        return ViewPagerViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.binding.restaurantImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
    inner class  ViewPagerViewHolder(val binding: RestaurantImageItemBinding): RecyclerView.ViewHolder(binding.root)

}