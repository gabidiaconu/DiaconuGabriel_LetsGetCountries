package com.lgcinterview.letsgetcountries.common

import android.app.Application
import androidx.room.Room
import com.lgcinterview.letsgetcountries.data.db.localdb.LetsGetCountriesDatabase
import com.lgcinterview.letsgetcountries.data.repositories.CountriesRepository
import com.lgcinterview.letsgetcountries.data.retrofit.RetrofitSource
import com.lgcinterview.letsgetcountries.di.ViewModelFactory
import com.lgcinterview.letsgetcountries.di.bindViewModel
import com.lgcinterview.letsgetcountries.ui.main.fragments.allcountries.AllCountriesViewModel
import com.lgcinterview.letsgetcountries.ui.main.fragments.countrydetails.CountryDetailsViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.direct
import org.kodein.di.generic.*

class LetsGetCountriesApplication : Application(), KodeinAware{
    override val kodein = Kodein.lazy {
        import(androidXModule(this@LetsGetCountriesApplication))

        bind() from singleton { CountriesRepository(instance(), instance()) }
        bind() from singleton { RetrofitSource()}
        bind() from singleton { instance<LetsGetCountriesDatabase>().countriesDao() }
        bind<LetsGetCountriesDatabase>() with eagerSingleton {
            Room.databaseBuilder(this@LetsGetCountriesApplication, LetsGetCountriesDatabase::class.java, "lgcdb")
                .allowMainThreadQueries()
                .build() }

        bind<ViewModelFactory>() with singleton  { ViewModelFactory(kodein.direct) }

        bindViewModel<AllCountriesViewModel>() with provider { AllCountriesViewModel(instance()) }
        bindViewModel<CountryDetailsViewModel>() with provider {
            CountryDetailsViewModel(instance())
        }

    }
}