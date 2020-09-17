package com.lgcinterview.letsgetcountries.ui.main.fragments.allcountries

import androidx.lifecycle.*
import com.lgcinterview.letsgetcountries.common.CountriesResultVisibilityCase
import com.lgcinterview.letsgetcountries.common.SealedResources
import com.lgcinterview.letsgetcountries.data.models.Country
import com.lgcinterview.letsgetcountries.data.repositories.CountriesRepository

class AllCountriesViewModel(
    repository: CountriesRepository
) : ViewModel() {

    private val _msg = MutableLiveData<String>()
    val msg : LiveData<String>
        get() = _msg

    private val _countriesResultVisibilityCase = MutableLiveData<CountriesResultVisibilityCase>()
    val countriesResultVisibilityCase : LiveData<CountriesResultVisibilityCase>
        get() = _countriesResultVisibilityCase


    val listOfAllCountries : LiveData<SealedResources<List<Country>>> =
            repository.getAllCountries().asLiveData()

    fun loadingState(){
        _msg.postValue("Loading...")
        _countriesResultVisibilityCase.postValue(CountriesResultVisibilityCase.LOADING_DATA)
    }

    fun dataCollectedSuccesfulyState(){
        _countriesResultVisibilityCase.postValue(CountriesResultVisibilityCase.DATA_LOADED)
    }

    fun errorState(str : String){
        _msg.postValue(str)
        _countriesResultVisibilityCase.postValue(CountriesResultVisibilityCase.NO_DATA)
    }
}