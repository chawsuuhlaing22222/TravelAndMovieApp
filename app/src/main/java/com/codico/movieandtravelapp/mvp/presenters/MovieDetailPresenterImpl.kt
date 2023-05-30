package com.codico.movieandtravelapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.codico.movieandtravelapp.data.models.MovieModel
import com.codico.movieandtravelapp.data.models.MovieModelImpl
import com.codico.movieandtravelapp.data.vos.MovieVO
import com.codico.movieandtravelapp.mvp.views.MovieDetailView


class MovieDetailPresenterImpl:ViewModel(), MovieDetailPresenter {

    //model
    private val mMovieModel: MovieModel = MovieModelImpl

    //view
    var mView: MovieDetailView?=null

    override fun initView(view: MovieDetailView) {
       mView = view
    }

    override fun onUiReadyInMovieDetail(owner: LifecycleOwner, movieId: Int) {
       //movie detail
        mMovieModel.getMovieDetail(movieId = movieId.toString()
        ) {
            mView?.showErrorMsg(it)

        }?.observe(owner) {
            if (it != null) {
                mView?.showMovieDetail(it)
            }
        }

        //actors
        mMovieModel.getMovieCredits(movieId = movieId.toString(),{

            mView?.showCreditsByMovie(it)

        },{
            mView?.showErrorMsg(it)
        })
    }

    override fun onTapBack() {
       mView?.navigateBack()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    fun onLoveMovie(movie: MovieVO) {
        mMovieModel.loveMove(movie)
    }
}