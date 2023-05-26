package com.axb.marvelgallery2.view.main

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.axb.marvelgallery2.R
import com.axb.marvelgallery2.model.MarvelCharacter
import com.axb.marvelgallery2.view.common.ItemAdapter
import com.axb.marvelgallery2.view.common.bindView
import com.axb.marvelgallery2.view.common.loadImage


class CharacterItemAdapter(
        val character: MarvelCharacter,
        val clicked: (MarvelCharacter) -> Unit
) : ItemAdapter<CharacterItemAdapter.ViewHolder>(R.layout.item_character) {

    override fun onCreateViewHolder(itemView: View) = ViewHolder(itemView)

    override fun ViewHolder.onBindViewHolder() {
        textView.text = character.name
        character.imageUrl?.let { imageView.loadImage(it) }
        itemView.setOnClickListener { clicked(character) }

        Log.d(TAG, "onBindViewHolder: character.imageUrl = " + character.imageUrl)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView by bindView<TextView>(R.id.textView)
        val imageView: ImageView by bindView<ImageView>(R.id.imageView)
    }
}
