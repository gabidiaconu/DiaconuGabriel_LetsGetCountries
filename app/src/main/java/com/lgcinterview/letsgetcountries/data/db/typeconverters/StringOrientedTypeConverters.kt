package com.lgcinterview.letsgetcountries.data.db.typeconverters

import androidx.room.TypeConverter

object StringOrientedTypeConverters {

    @JvmStatic
    @TypeConverter
    fun stringToStringsList(data : String?) : List<String>? = data?.split(";")

    @JvmStatic
    @TypeConverter
    fun stringsListToString(stringsList : List<String>?) : String? = stringsList?.joinToString(";")
}