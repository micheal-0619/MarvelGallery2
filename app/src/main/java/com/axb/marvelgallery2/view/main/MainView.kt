package com.axb.marvelgallery2.view.main

import com.axb.marvelgallery2.model.MarvelCharacter

interface MainView {
    var refresh: Boolean
    fun show(items: List<MarvelCharacter>)
    fun showError(error: Throwable)
}