package com.codico.movieandtravelapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.codico.movieandtravelapp.data.vos.CollectionVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CollectionTypeConverter {

    @TypeConverter
    fun toString(collectionVO: CollectionVO?):String{
        return Gson().toJson(collectionVO)
    }

    @TypeConverter
    fun toCollectionVo(collectionList:String):CollectionVO?{
        var collectionType=object :TypeToken<CollectionVO?>(){}.type
        return Gson().fromJson(collectionList,collectionType)
    }
}