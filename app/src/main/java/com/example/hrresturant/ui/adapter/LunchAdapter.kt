package com.example.hrresturant.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hrresturant.data.CommonInterface
import com.example.hrresturant.databinding.HorizentalItemBinding
import com.example.hrresturant.ui.adapter.base.PolyMorphism

class LunchAdapter(private val mealList: List<CommonInterface?>) :
    RecyclerView.Adapter<LunchAdapter.ItemViewHolder>(), PolyMorphism {

    override var adapter: RecyclerView.Adapter<*> = this

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            HorizentalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.price.text = mealList[position]?.price.toString()
        holder.binding.mealTitle.text = mealList[position]?.title
        holder.binding.description.text = mealList[position]?.description
        holder.binding.estimatedTime.text = mealList[position]?.estimatedTime.toString().plus(" M")
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    inner class ItemViewHolder(val binding: HorizentalItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}