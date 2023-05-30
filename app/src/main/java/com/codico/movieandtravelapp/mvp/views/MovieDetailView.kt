package com.codico.movieandtravelapp.mvp.views

import com.codico.movieandtravelapp.data.vos.ActorVO
import com.codico.movieandtravelapp.data.vos.MovieVO

interface MovieDetailView:BaseView {
    fun showMovieDetail(movie: MovieVO)
    fun showCreditsByMovie(casts:List<ActorVO>)
    fun navigateBack()
}