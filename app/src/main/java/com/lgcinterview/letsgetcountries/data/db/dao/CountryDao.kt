package com.lgcinterview.letsgetcountries.data.db.dao

import androidx.room.*
import com.lgcinterview.letsgetcountries.data.models.Country

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(country: Country) : Long

    @Update
    suspend fun updateCountry(country: Country)

    @Query("SELECT * FROM countries")
    suspend fun getAllCountries() : List<Country>

    @Query("DELETE FROM countries ")
    suspend fun deleteAllCountries()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(listWeather: List<Country>)

    @Transaction
    suspend fun deleteAllAndInsert(countries: List<Country>) {
        deleteAllCountries()
        insertList(countries)
    }

    @Query("SELECT count(*) FROM countries")
    suspend fun getCountriesListSize() : Int

}