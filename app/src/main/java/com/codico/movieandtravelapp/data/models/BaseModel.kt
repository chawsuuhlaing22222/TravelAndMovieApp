package com.codico.movieandtravelapp.data.models

import android.content.Context

import com.codico.movieandtravelapp.network.TheMovieApi
import com.codico.movieandtravelapp.persistence.MovieDatabase
import com.codico.movieandtravelapp.utils.BASE_URL
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected var mTheMovieApi: TheMovieApi
    protected var movieDb: MovieDatabase? = null
    init {
        val okHttpClient= OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        mTheMovieApi=retrofit.create(TheMovieApi::class.java)
    }

    fun initDB(context: Context) {
        movieDb = MovieDatabase.getDBInstance(context)
    }
}