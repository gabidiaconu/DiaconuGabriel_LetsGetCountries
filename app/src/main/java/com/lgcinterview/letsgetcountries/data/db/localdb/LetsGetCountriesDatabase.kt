package com.lgcinterview.letsgetcountries.data.db.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lgcinterview.letsgetcountries.data.db.dao.CountryDao
import com.lgcinterview.letsgetcountries.data.db.dao.TranslationDao
import com.lgcinterview.letsgetcountries.data.db.typeconverters.DoubleListStringTypeConverter
import com.lgcinterview.letsgetcountries.data.db.typeconverters.StringOrientedTypeConverters
import com.lgcinterview.letsgetcountries.data.models.Country
import com.lgcinterview.letsgetcountries.data.models.Translation

@Database(entities = [Country::class, Translation::class], version = 1, exportSchema = false)
@TypeConverters(value = [DoubleListStringTypeConverter::class, StringOrientedTypeConverters::class])
abstract class LetsGetCountriesDatabase : RoomDatabase() {

    abstract fun countriesDao() : CountryDao
    abstract fun translationDao() : TranslationDao

    companion object {
        private var INSTANCE : LetsGetCountriesDatabase? = null

        fun getAppDataBase(context: Context): LetsGetCountriesDatabase? {
            if (INSTANCE == null){
                synchronized(LetsGetCountriesDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, LetsGetCountriesDatabase::class.java, "lgcDb").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

}