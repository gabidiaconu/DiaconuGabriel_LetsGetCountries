package com.lgcinterview.letsgetcountries.common

@Suppress("DataClassPrivateConstructor")
data class CountriesResultVisibilityCase private constructor(val visibilityCase: VisibilityCase ){

    companion object {
        val LOADING_DATA = CountriesResultVisibilityCase(VisibilityCase.LOADING_DATA)
        val DATA_LOADED = CountriesResultVisibilityCase(VisibilityCase.DATA_LOADED)
        val NO_DATA = CountriesResultVisibilityCase(VisibilityCase.NO_DATA)
    }

    enum class VisibilityCase{
        LOADING_DATA,
        DATA_LOADED,
        NO_DATA
    }
}