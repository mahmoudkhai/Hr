package com.example.hrresturant.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.hrresturant.data.PizzaEntity

class MyDiffUtil(private val newList: List<PizzaEntity?>, private val oldList: List<PizzaEntity?>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldListSize

    override fun getNewListSize(): Int = newListSize

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition]?.title == newList[newItemPosition]?.title &&
                oldList[oldItemPosition]?.description == newList[newItemPosition]?.description


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition]?.description == newList[newItemPosition]?.description &&
                oldList[oldItemPosition]?.title == newList[newItemPosition]?.title


}
