package com.codico.movieandtravelapp
import android.app.Application
import com.codico.movieandtravelapp.data.models.MovieModelImpl

class MovieAndTravelApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDB(applicationContext)


    }
}