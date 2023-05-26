package com.axb.marvelgallery2.presenter

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter : Presenter {

    protected var subscriptions = CompositeDisposable()

    override fun onViewDestroyed() {
        subscriptions.dispose()
    }
}
