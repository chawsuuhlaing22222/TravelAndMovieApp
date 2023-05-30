package com.codico.movieandtravelapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner

interface IBasePresenter {

    //to show initial data of view
    fun onUiReady(owner:LifecycleOwner)
}