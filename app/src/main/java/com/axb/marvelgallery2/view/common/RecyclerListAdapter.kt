package com.axb.marvelgallery2.view.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class RecyclerListAdapter( // 1
    initialList: List<AnyItemAdapter> = listOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val items = initialList.toMutableList() // 2

    final override fun getItemCount() = items.size // 4

    final override fun getItemViewType(position: Int) = items[position].layoutId // 3, 4

    final override fun onCreateViewHolder(
        parent: ViewGroup,
        layoutId: Int
    ): RecyclerView.ViewHolder { // 4
        val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return items.first { it.layoutId == layoutId }.onCreateViewHolder(itemView) // 3
    }

    final override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) { // 4
        items[position].bindViewHolder(holder)
    }
}

typealias AnyItemAdapter = ItemAdapter<out RecyclerView.ViewHolder> // 5