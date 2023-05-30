package com.codico.movieandtravelapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codico.movieandtravelapp.data.vos.MovieVO


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies:List<MovieVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleMovie(movieVO: MovieVO)
    
    @Query(value = "SELECT * FROM movies")
    fun getAllMovies():LiveData<List<MovieVO>>

    @Query(value = "SELECT * FROM movies WHERE id = :movieId")
    fun getSingleMovie(movieId:Int):LiveData<MovieVO?>

    @Query(value = "SELECT * FROM movies WHERE id = :movieId")
    fun getSingleMovieOneTime(movieId:Int):MovieVO?

    @Query(value = "SELECT * FROM movies WHERE type = :type")
    fun getMovieListByType(type:String):LiveData<List<MovieVO>>

   @Query("DELETE FROM movies")
    fun deleteAllMovies()

    @Query("UPDATE movies SET favourite = :isFav WHERE id = :movieId")
    fun loveAtMovie(movieId:Int,isFav:Boolean)

}