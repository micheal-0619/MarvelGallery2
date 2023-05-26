package com.axb.marvelgallery2.helpers

import com.axb.marvelgallery2.model.MarvelCharacter
import com.axb.marvelgallery2.view.main.MainView


class BaseMainView(
    var onShow: (items: List<MarvelCharacter>) -> Unit = {},
    val onShowError: (error: Throwable) -> Unit = {},
    override var refresh: Boolean = false
) : MainView {

    override fun show(items: List<MarvelCharacter>) {
        onShow(items)
    }

    override fun showError(error: Throwable) {
        onShowError(error)
    }
}