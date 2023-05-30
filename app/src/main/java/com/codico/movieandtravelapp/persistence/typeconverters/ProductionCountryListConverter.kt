package com.codico.movieandtravelapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.codico.movieandtravelapp.data.vos.ProductionCountryVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductionCountryListConverter {
    @TypeConverter
    fun toString(productionCountryList:List<ProductionCountryVO>?):String{
        return Gson().toJson(productionCountryList)
    }

    @TypeConverter
    fun toProductionCountryList(productionCountryList: String):List<ProductionCountryVO>?{
        var toType=object : TypeToken<List<ProductionCountryVO>?>(){}.type
        return Gson().fromJson(productionCountryList,toType)
    }
}