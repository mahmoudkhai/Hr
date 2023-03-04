package com.example.hrresturant.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hrresturant.data.dataSources.CommonInterface
import com.example.hrresturant.data.dataSources.local.ItemEntity
import com.example.hrresturant.databinding.VerticalItemBinding
import com.example.hrresturant.ui.base.PolyMorphism
import com.example.hrresturant.ui.fragment.bottomNav.favourite.FavouriteFragment

class VerticalAdapter(
    private val listener: ItemListener,
    private val context: Context,
    private var oldList: List<ItemEntity?>
) :
    RecyclerView.Adapter<VerticalAdapter.ItemViewHolder>(), PolyMorphism {
    //    private lateinit var oldList: List<ItemEntity?>
    var checkedList: MutableList<CommonInterface> = mutableListOf()
    override var adapter: RecyclerView.Adapter<*> = this

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            VerticalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return oldList.size
    }

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
            itemTitle.text = item?.title
            description.text = item?.description
            estimatedTimeValue.text = item?.estimatedTime
        }
    }

    fun setNewData(newList: List<ItemEntity>) {
        val diffUtil = MyDiffUtil(newList, oldList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldList = newList
        diffResult.dispatchUpdatesTo(this)

    }

    inner class ItemViewHolder(val binding: VerticalItemBinding) :
        RecyclerView.ViewHolder(binding.root)


}