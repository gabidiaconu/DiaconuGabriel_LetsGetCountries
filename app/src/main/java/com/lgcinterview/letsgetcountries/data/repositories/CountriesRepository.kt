package com.lgcinterview.letsgetcountries.data.repositories

import com.lgcinterview.letsgetcountries.common.SealedResources
import com.lgcinterview.letsgetcountries.data.db.dao.CountryDao
import com.lgcinterview.letsgetcountries.data.models.Country
import com.lgcinterview.letsgetcountries.data.retrofit.RetrofitSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CountriesRepository(
    private val retrofitSource: RetrofitSource,
    private val countryDao: CountryDao
) {

    fun getAllCountries() : Flow<SealedResources<List<Country>>> {
        return flow{

            emit(SealedResources.Loading(""))

           if (countryDao.getCountriesListSize() > 1){
               val directFromDbData = countryDao.getAllCountries()
               emit(SealedResources.Success<List<Country>>(directFromDbData))
           } else {

               emit(SealedResources.Loading(""))

               val apiBody = retrofitSource.retrofitRequests.getAllCountries()

               emit(SealedResources.Loading(""))

               countryDao.deleteAllAndInsert(apiBody)

               emit(SealedResources.Loading(""))

               val directFromDbData = countryDao.getAllCountries()

               emit(SealedResources.Success<List<Country>>(directFromDbData))
           }

        }.flowOn(Dispatchers.IO)
    }
}