package com.axb.marvelgallery2.view.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class RecyclerListAdapter(//此处未采用抽象机制，其原因在于，无须使用任何子元素即可初始化并加以
    //使用 。 针对不同的列表，可定义子元素，进而设置自定义方法
    var items: List<AnyItemAdapter> = listOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    final override fun getItemCount() = items.size

    final override fun getItemViewType(position: Int) =
        items[position].layoutId

    final override fun onCreateViewHolder(
        parent: ViewGroup,
        layoutId: Int
    ): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return items.first { it.layoutId == layoutId }.onCreateViewHolder(itemView)
    }

    final override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        items[position].bindViewHolder(holder)
    }

}

typealias AnyItemAdapter = ItemAdapter<out RecyclerView.ViewHolder> // 5