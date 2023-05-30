package com.codico.movieandtravelapp.mvp.views

import com.codico.movieandtravelapp.data.vos.MovieVO

//to send action to view from presenter
interface MovieListView :BaseView{

    fun showNowPlayingMovies(nowPlayingMovieList:List<MovieVO>)
    fun showPopularMovies(popularMovieList:List<MovieVO>)
    fun showUpCommingMovies(upcommingMovieList:List<MovieVO>)
    fun navigateToMovieDetailScrn(movieId:Int)
}