package com.codico.movieandtravelapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.codico.movieandtravelapp.data.vos.GenreVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class
GenreListTypeConverter {

    @TypeConverter
    fun toString(genreList:List<GenreVO>?):String{
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toGenreList(genreList: String):List<GenreVO>?{
        var toType=object : TypeToken<List<GenreVO>?>(){}.type
        return Gson().fromJson(genreList,toType)
    }
}