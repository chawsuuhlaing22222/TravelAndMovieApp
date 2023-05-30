package com.codico.movieandtravelapp.delegates

import com.codico.movieandtravelapp.data.vos.MovieVO

interface MovieDelegate {

    fun onTapMovie(movie: MovieVO)
    fun  onLoveMovie(movie: MovieVO)
}