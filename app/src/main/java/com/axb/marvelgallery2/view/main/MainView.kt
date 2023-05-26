package com.axb.marvelgallery2.view.main

import com.axb.marvelgallery2.model.MarvelCharacter
import com.axb.marvelgallery2.presenter.MainPresenter

interface MainView {
    var refresh: Boolean
    fun show(items: List<MarvelCharacter>)
    fun showError(error: Throwable)
    val presenter: MainPresenter
}