package com.lgcinterview.letsgetcountries.ui.main.fragments.countrydetails

import androidx.lifecycle.ViewModel
import com.lgcinterview.letsgetcountries.data.models.Country
import com.lgcinterview.letsgetcountries.data.repositories.CountriesRepository

class CountryDetailsViewModel(
    repository : CountriesRepository
) : ViewModel() {

    lateinit var selectedCountry : Country

}