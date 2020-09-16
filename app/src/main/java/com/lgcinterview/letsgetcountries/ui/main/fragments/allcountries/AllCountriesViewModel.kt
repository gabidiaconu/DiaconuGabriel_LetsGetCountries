package com.lgcinterview.letsgetcountries.ui.main.fragments.allcountries

import androidx.lifecycle.*
import com.lgcinterview.letsgetcountries.common.SealedResources
import com.lgcinterview.letsgetcountries.data.models.Country
import com.lgcinterview.letsgetcountries.data.repositories.CountriesRepository

class AllCountriesViewModel(
    repository: CountriesRepository
) : ViewModel() {


    val listOfAllCountries : LiveData<SealedResources<List<Country>>> =
            repository.getAllCountries().asLiveData()
}