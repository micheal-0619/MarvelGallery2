package com.axb.marvelgallery2.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.GridLayoutManager
import com.axb.marvelgallery2.R
import com.axb.marvelgallery2.data.network.MarvelRepository
import com.axb.marvelgallery2.model.MarvelCharacter
import com.axb.marvelgallery2.presenter.MainPresenter
import com.axb.marvelgallery2.view.character.CharacterProfileActivity
import com.axb.marvelgallery2.view.common.BaseActivityWithPresenter
import com.axb.marvelgallery2.view.common.addOnTextChangedListener
import com.axb.marvelgallery2.view.common.bindToSwipeRefresh
import com.axb.marvelgallery2.view.common.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivityWithPresenter(), MainView {

    override var refresh by bindToSwipeRefresh(R.id.swipeRefreshView) // 2
    override val presenter by lazy { MainPresenter(this, MarvelRepository.get()) } // 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this, 2) //3
        swipeRefreshView.setOnRefreshListener { presenter.onRefresh() } // 4
        searchView.addOnTextChangedListener {
            onTextChanged { text, _, _, _ ->
                presenter.onSearchChanged(text)
            }
        }
        presenter.onViewCreated() // 4

    }

    override fun show(items: List<MarvelCharacter>) {
        val categoryItemAdapters = items.map(this::createCategoryItemAdapter)
        recyclerView.adapter = MainListAdapter(categoryItemAdapters)
    }

    override fun showError(error: Throwable) {
        toast("Error: ${error.message}") // 2
        error.printStackTrace()
    }

    private fun createCategoryItemAdapter(character: MarvelCharacter) =
        CharacterItemAdapter(character, { showHeroProfile(character) })

    private fun showHeroProfile(character: MarvelCharacter) {
        CharacterProfileActivity.start(this, character)
    }
}