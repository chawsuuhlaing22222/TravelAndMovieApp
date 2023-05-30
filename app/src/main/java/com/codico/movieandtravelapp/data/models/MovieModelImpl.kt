package com.codico.movieandtravelapp.data.models

import androidx.lifecycle.LiveData
import com.codico.movieandtravelapp.data.vos.ActorVO
import com.codico.movieandtravelapp.data.vos.MovieVO
import com.codico.movieandtravelapp.data.vos.POPULAR
import com.codico.movieandtravelapp.data.vos.UPCOMMING
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object MovieModelImpl : MovieModel, BaseModel() {


    override fun getPopularMovies( onFailure: (String) -> Unit):LiveData<List<MovieVO>>? {

        mTheMovieApi.getPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {

                it.results?.forEach { movie ->
                    movie.type = POPULAR

                    var dbMovie= movie.id?.let { it1 ->
                        movieDb?.movieDao()?.getSingleMovieOneTime(
                            it1
                        )
                    }
                    dbMovie?.let {
                        movie.isFavourite=it.isFavourite
                    }

                }
                movieDb?.movieDao()?.insertMovies(it.results ?: listOf())
              //  onSuccess(it.results ?: listOf())
            }, {
                onFailure(it.localizedMessage ?: "")
            })

       return movieDb?.movieDao()?.getMovieListByType(POPULAR)
    }



    override fun getUpCommingMovie(onFailure: (String) -> Unit): LiveData<List<MovieVO>>? {
        mTheMovieApi.getUpCommingMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {

                it.results?.forEach { movie ->
                    movie.type = UPCOMMING
                    var dbMovie= movie.id?.let { it1 ->
                        movieDb?.movieDao()?.getSingleMovieOneTime(
                            it1
                        )
                    }
                    dbMovie?.let {
                        movie.isFavourite=it.isFavourite
                    }
                }
                movieDb?.movieDao()?.insertMovies(it.results ?: listOf())
                //  onSuccess(it.results ?: listOf())
            }, {
                onFailure(it.localizedMessage ?: "")
            })

        return movieDb?.movieDao()?.getMovieListByType(UPCOMMING)
    }

    override fun getMovieDetail(
        movieId: String,
        onFailure: (String) -> Unit
    ) :LiveData<MovieVO?>?{

        //network
        mTheMovieApi.getMovieDetail(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                val movie = movieDb?.movieDao()?.getSingleMovieOneTime(movieId = movieId.toInt())
                it.type = movie?.type
                it.isFavourite=movie?.isFavourite ?: false
                movieDb?.movieDao()?.insertSingleMovie(it)

            }, {
                onFailure(it.localizedMessage ?: "")
            })
        return movieDb?.movieDao()?.getSingleMovie(movieId = movieId.toInt())
    }


    override fun getMovieCredits(
        movieId: String,
        onSuccess: (List<ActorVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mTheMovieApi.getCreditByMovie(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                onSuccess(it.cast ?: listOf())

            }, {

                onFailure(it.localizedMessage ?: "")

            })

    }

    override fun loveMove(movieVO: MovieVO) {

        var loveFlag=!movieVO.isFavourite
        movieVO.isFavourite=loveFlag
        movieVO.id?.let { movieDb?.movieDao()?.loveAtMovie(it,loveFlag) }
    }



}