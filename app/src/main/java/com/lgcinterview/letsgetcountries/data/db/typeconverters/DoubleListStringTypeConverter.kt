package com.lgcinterview.letsgetcountries.data.db.typeconverters

import androidx.room.TypeConverter
import java.lang.NumberFormatException

object DoubleListStringTypeConverter {

    @JvmStatic
    @TypeConverter
    fun stringToDoubleList(data : String?) : List<Double>? {
        return data?.let {
            it.split(";").mapNotNull {
                try {
                    it.toDouble()
                } catch (e: NumberFormatException) {
                    null
                }
            }
        }
    }

    @JvmStatic
    @TypeConverter
    fun doubleListToString(doublesList : List<Double>?) : String? = doublesList?.joinToString(";")

}