package com.lgcinterview.letsgetcountries.common

import com.lgcinterview.letsgetcountries.data.models.Country

sealed class SealedResources<out T: Any> {
    data class Loading(val msg : String) : SealedResources<Nothing>()
    data class Success<out T : Any>(val data: List<Country>) : SealedResources<T>()
    data class Failure(val exception: Exception) : SealedResources<Nothing>()
}