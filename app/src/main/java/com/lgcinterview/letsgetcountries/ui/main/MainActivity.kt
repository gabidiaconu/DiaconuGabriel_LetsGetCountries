package com.lgcinterview.letsgetcountries.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lgcinterview.letsgetcountries.R
import com.lgcinterview.letsgetcountries.databinding.ActivityMainBinding
import com.lgcinterview.letsgetcountries.ui.main.fragments.allcountries.AllCountriesFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    private lateinit var binding : ActivityMainBinding

    private var doubleBackPressToExitPressedTwice : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        this.replaceFragment(AllCountriesFragment.newInstance())
    }

    override fun onBackPressed() {
        if (doubleBackPressToExitPressedTwice){
            finish()
        } else {
            Toast.makeText(this, "Double press twice to exit the app", Toast.LENGTH_LONG).show()
        }
        doubleBackPressToExitPressedTwice = true
        GlobalScope.launch {
            delay(1000L)
            doubleBackPressToExitPressedTwice = false
        }
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