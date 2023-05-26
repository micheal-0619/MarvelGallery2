package com.axb.marvelgallery2.view.common

import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class ItemAdapter<T : RecyclerView.ViewHolder>
    (@LayoutRes open val layoutId: Int) {
    //须作为类型参数传递一个加载器，并可在其字段上直接进行操作
    abstract fun onCreateViewHolder(itemView: View): T //函数用于创建视图加载器

    @Suppress("UNCHECKED_CAST")
    fun bindViewHolder(holder: RecyclerView.ViewHolder) {
        (holder as T).onBindViewHolder()
    }

    abstract fun T.onBindViewHolder()//在onBindViewHolder 函数中，将设置数据项视图上的全部数值。
}