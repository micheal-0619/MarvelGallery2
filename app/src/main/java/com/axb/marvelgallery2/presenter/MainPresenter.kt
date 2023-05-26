package com.axb.marvelgallery2.presenter

import com.axb.marvelgallery2.data.network.MarvelRepository
import com.axb.marvelgallery2.data.network.applySchedulers
import com.axb.marvelgallery2.data.network.plusAssign
import com.axb.marvelgallery2.data.network.smartSubscribe
import com.axb.marvelgallery2.view.main.MainView


class MainPresenter(val view: MainView, val repository: MarvelRepository): BasePresenter() {

    fun onViewCreated() {
        loadCharacters()
    }

    fun onRefresh() {
        loadCharacters()
    }

    private fun loadCharacters() {
        subscriptions += repository.getAllCharacters()
                .applySchedulers()
                .smartSubscribe(
                        onStart = { view.refresh = true },
                        onSuccess = view::show,
                        onError = view::showError,
                        onFinish = { view.refresh = false }
                )
    }
}
