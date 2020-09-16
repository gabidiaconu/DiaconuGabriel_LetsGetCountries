package com.lgcinterview.letsgetcountries.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lgcinterview.letsgetcountries.R
import com.lgcinterview.letsgetcountries.databinding.ActivityMainBinding
import com.lgcinterview.letsgetcountries.ui.main.fragments.allcountries.AllCountriesFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        this.replaceFragment(AllCountriesFragment.newInstance())
    }
}

// Extension function to replace fragment
fun AppCompatActivity.replaceFragment(fragment: Fragment){
    val fragmentManager = supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.replace(R.id.fragment_container,fragment)
    transaction.addToBackStack(null)
    transaction.commit()
}