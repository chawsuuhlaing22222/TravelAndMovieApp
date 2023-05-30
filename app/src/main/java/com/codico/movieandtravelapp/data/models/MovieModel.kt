package com.codico.movieandtravelapp.data.models

import androidx.lifecycle.LiveData
import com.codico.movieandtravelapp.data.vos.ActorVO
import com.codico.movieandtravelapp.data.vos.MovieVO

interface MovieModel {

    fun getUpCommingMovie(
        onFailure:(String)->Unit
    ):LiveData<List<MovieVO>>?

    fun getPopularMovies(
        onFailure:(String)->Unit
    ):LiveData<List<MovieVO>>?

    fun getMovieDetail(
        movieId:String,
        onFailure: (String) -> Unit
    ):LiveData<MovieVO?>?

    fun getMovieCredits(
        movieId:String,
        onSuccess: (List<ActorVO>) -> Unit,
        onFailure: (String) -> Unit
    )

     fun loveMove(movieVO: MovieVO)



}