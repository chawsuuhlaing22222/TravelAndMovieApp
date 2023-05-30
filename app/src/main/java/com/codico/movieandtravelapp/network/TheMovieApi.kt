package com.codico.movieandtravelapp.network


import com.codico.movieandtravelapp.data.vos.MovieVO
import com.codico.movieandtravelapp.network.responses.MovieCreditResponse
import com.codico.movieandtravelapp.network.responses.MovieListResponse
import com.codico.movieandtravelapp.utils.*
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieApi {


    @GET(API_GET_UP_COMMING)
    fun getUpCommingMovies(
        @Query(PARAM_API_KEY) apiKey:String = MOVIE_API_KEY,
        @Query(PARAM_PAGE) page:Int =1
    ): Observable<MovieListResponse>

    @GET(API_GET_POPULAR_MOVIES)
    fun getPopularMovies(
        @Query(PARAM_API_KEY) apiKey:String = MOVIE_API_KEY,
        @Query(PARAM_PAGE) page:Int =1
    ): Observable<MovieListResponse>



   @GET("${API_GET_MOVIE_DETAIL}{movie_id}")
    fun getMovieDetail(
       @Path(PATH_PARAM_MOVIE_ID) movieId:String,
       @Query(PARAM_API_KEY)  api_key:String= MOVIE_API_KEY

    ):Observable<MovieVO>

    @GET("${API_GET_CREDITS_BY_MOVIE}{movie_id}/credits")
    fun getCreditByMovie(
        @Path(PATH_PARAM_MOVIE_ID) movieId:String,
        @Query(PARAM_API_KEY)  api_key:String= MOVIE_API_KEY

    ):Observable<MovieCreditResponse>





}