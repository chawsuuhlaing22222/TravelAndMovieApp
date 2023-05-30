package com.codico.movieandtravelapp.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codico.movieandtravelapp.data.vos.GenreVO
import com.codico.movieandtravelapp.data.vos.MovieVO
import com.codico.movieandtravelapp.data.vos.ProductionCountryVO
import com.codico.movieandtravelapp.persistence.daos.MovieDao

@Database(entities = [MovieVO::class, GenreVO::class, ProductionCountryVO::class], version = 3, exportSchema = false)
abstract class MovieDatabase:RoomDatabase() {

    companion object{
        const val DB_NAME="THE_MOVIE_DB"
        var movieDatabase: MovieDatabase?=null
        fun getDBInstance(context:Context):MovieDatabase?{

            when(movieDatabase){
                null->{
                    movieDatabase= Room.databaseBuilder(context,MovieDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()

                }
              }

            return movieDatabase
        }

    }

    abstract fun movieDao(): MovieDao
}

