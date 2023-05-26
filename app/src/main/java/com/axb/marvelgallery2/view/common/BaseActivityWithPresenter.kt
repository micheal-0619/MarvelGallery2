package com.axb.marvelgallery2.view.common

import androidx.appcompat.app.AppCompatActivity
import com.axb.marvelgallery2.presenter.Presenter


abstract class BaseActivityWithPresenter : AppCompatActivity() {

    abstract val presenter: Presenter

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}
