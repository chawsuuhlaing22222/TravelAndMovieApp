package com.codico.movieandtravelapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.codico.movieandtravelapp.data.models.MovieModel
import com.codico.movieandtravelapp.data.models.MovieModelImpl
import com.codico.movieandtravelapp.data.vos.MovieVO
import com.codico.movieandtravelapp.mvp.views.MovieListView

class MovieListPresenterImpl:ViewModel(), MovieListPresenter {

    //view
    var mView: MovieListView?=null

    //model
    private var mMovieModel: MovieModel = MovieModelImpl

    override fun initView(view: MovieListView) {
        mView = view
    }


    override fun onUiReady(owner: LifecycleOwner) {

        //upcomming Movies
        mMovieModel.getUpCommingMovie {
            mView?.showErrorMsg(it)
        }?.observe(owner) {
            mView?.showUpCommingMovies(it)
        }

        //Popular movies
        mMovieModel.getPopularMovies{
            mView?.showErrorMsg(it)
        }?.observe(owner) {
            mView?.showPopularMovies(it)
        }

    }

    override fun onTapMovie(movie: MovieVO) {
        movie.id?.let { mView?.navigateToMovieDetailScrn(it) }
    }

    override fun onLoveMovie(movie: MovieVO) {
        mMovieModel.loveMove(movie)
    }

}