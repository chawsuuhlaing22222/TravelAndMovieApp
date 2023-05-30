package com.codico.movieandtravelapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.codico.movieandtravelapp.mvp.views.MovieDetailView


interface MovieDetailPresenter: IBasePresenter {

    fun initView(view: MovieDetailView)
    fun onUiReadyInMovieDetail(owner: LifecycleOwner, movieId:Int)
    fun onTapBack()
}