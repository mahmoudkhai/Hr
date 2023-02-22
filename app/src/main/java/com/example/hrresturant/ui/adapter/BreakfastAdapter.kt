package com.example.hrresturant.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hrresturant.data.CommonInterface
import com.example.hrresturant.databinding.HorizentalItemBinding
import com.example.hrresturant.databinding.VerticalItemBinding
import com.example.hrresturant.ui.adapter.base.PolyMorphism

class BreakfastAdapter(private val list: List<CommonInterface?>) :
    RecyclerView.Adapter<BreakfastAdapter.ItemViewHolder>(), PolyMorphism {

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

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            mealTitle.text = item?.title
            description.text = item?.description
            estimatedTimeValue.text = item?.estimatedTime.toString().plus(" M")
        }
    }
    inner class ItemViewHolder(val binding: HorizentalItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}