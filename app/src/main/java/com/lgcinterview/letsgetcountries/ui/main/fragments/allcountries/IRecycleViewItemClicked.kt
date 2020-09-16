package com.lgcinterview.letsgetcountries.ui.main.fragments.allcountries

import com.lgcinterview.letsgetcountries.data.models.Country

interface IRecycleViewItemClicked {
    fun onRecyclerViewItemClicked(country : Country)
}