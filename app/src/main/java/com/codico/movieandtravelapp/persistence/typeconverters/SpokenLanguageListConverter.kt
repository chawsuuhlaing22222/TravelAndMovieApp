package com.codico.movieandtravelapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.codico.movieandtravelapp.data.vos.LanguageVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SpokenLanguageListConverter {

    @TypeConverter
    fun toString(spokenLanguageList:List<LanguageVO>?):String{
        return Gson().toJson(spokenLanguageList)
    }

    @TypeConverter
    fun toSpokentLanguageList(spokenLanguageList: String):List<LanguageVO>?{
        var toType=object : TypeToken<List<LanguageVO>?>(){}.type
        return Gson().fromJson(spokenLanguageList,toType)
    }
}