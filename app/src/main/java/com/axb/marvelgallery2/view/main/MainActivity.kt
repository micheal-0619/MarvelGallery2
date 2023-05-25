package com.axb.marvelgallery2.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.GridLayoutManager
import com.axb.marvelgallery2.R
import com.axb.marvelgallery2.model.MarvelCharacter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val characters = listOf( // 1
        MarvelCharacter(
            name = "3-D Man",
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"
        ),
        MarvelCharacter(
            name = "Abomination (Emil Blonsky)",
            imageUrl = "http://i.annihil.us/u/prod/marvel/i/mg/9/50/4ce18691cbf04.jpg"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this, 2) //3
        val categoryItemAdapters = characters.map(::CharacterItemAdapter) // 4 
        recyclerView.adapter = MainListAdapter(categoryItemAdapters)

    }
}