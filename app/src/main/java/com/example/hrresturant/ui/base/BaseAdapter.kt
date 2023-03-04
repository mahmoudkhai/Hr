package com.example.hrresturant.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//abstract class BaseAdapter<T>(private val oldList: List<T?>) :
//    RecyclerView.Adapter<BaseAdapter.ItemViewHolder>(), PolyMorphism {
//
//    class ItemViewHolder(val binding: RecyclarViewItemBinding) : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        return ItemViewHolder(
//            RecyclarViewItemBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//
//
//    override fun getItemCount(): Int {
//        return oldList.size
//    }
//}