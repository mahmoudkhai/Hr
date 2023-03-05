package com.example.hrresturant.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.hrresturant.data.dataSources.local.Meal

class MyDiffUtil(private val newList: List<Meal?>, private val oldList: List<Meal?>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition]?.id == newList[newItemPosition]?.id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition]?.description == newList[newItemPosition]?.description &&
                oldList[oldItemPosition]?.title == newList[newItemPosition]?.title
//                oldList[oldItemPosition]?.isChecked == newList[newItemPosition]?.isChecked


}
