package com.lgcinterview.letsgetcountries.data.repositories

import com.lgcinterview.letsgetcountries.common.SealedResources
import com.lgcinterview.letsgetcountries.data.db.dao.CountryDao
import com.lgcinterview.letsgetcountries.data.models.Country
import com.lgcinterview.letsgetcountries.data.retrofit.RetrofitSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class CountriesRepository(
    private val retrofitSource: RetrofitSource,
    private val countryDao: CountryDao
) {

    fun getAllCountries() : Flow<SealedResources<List<Country>>> {
        return flow{

           if (countryDao.getCountriesListSize() > 1){
               val directFromDbData = countryDao.getAllCountries()
               emit(SealedResources.Success<List<Country>>(directFromDbData))
           } else {

               try {
                   val apiBody = retrofitSource.retrofitRequests.getAllCountries()

                   if (apiBody.size.compareTo(0) > 0) {
                       countryDao.deleteAllAndInsert(apiBody)

                       val directFromDbData = countryDao.getAllCountries()
                       emit(SealedResources.Success<List<Country>>(directFromDbData))

                   } else {
                       emit(SealedResources.Failure("Error receiving data from the server!"))
                   }
               } catch (e : Exception) {
                   emit(SealedResources.Failure("Error receiving data from the server!"))
               }
           }
        }.flowOn(Dispatchers.IO)
    }
}