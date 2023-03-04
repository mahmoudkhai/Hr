package com.example.hrresturant.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hrresturant.data.dataSources.local.ItemEntity
import com.example.hrresturant.databinding.HorizentalItemBinding
import com.example.hrresturant.ui.base.PolyMorphism

class HorizentalAdapter(
    private val listener: ItemListener,
    private val context: Context,
    private var oldList: List<ItemEntity?>
) :
    RecyclerView.Adapter<HorizentalAdapter.ItemViewHolder>(), PolyMorphism {

    override var adapter: RecyclerView.Adapter<*> = this


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = oldList[position]
        holder.binding.apply {
            if (item!!.isChecked) {
                favCheckBox.isChecked = true
            }
            favCheckBox.setOnCheckedChangeListener { checkBox, isChecked ->
                if (isChecked) {
                    listener.addItemToFavourite(item.id)
                } else {
                    listener.removeItemFromFavourite(item.id)
                }
            }
//            Glide.with(context).load(item?.itemImage).into(mealImg)
            mealTitle.text = item?.title
            description.text = item?.description
            estimatedTimeValue.text = item?.estimatedTime
        }
    }
    fun setNewData(newList:List<ItemEntity>) {
        val diffUtil = MyDiffUtil(newList , oldList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldList = newList
        diffResult.dispatchUpdatesTo(this)
    }
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
        return oldList.size
    }

    inner class ItemViewHolder(val binding: HorizentalItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}