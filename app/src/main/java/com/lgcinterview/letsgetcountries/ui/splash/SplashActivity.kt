package com.lgcinterview.letsgetcountries.ui.splash

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lgcinterview.letsgetcountries.R
import com.lgcinterview.letsgetcountries.databinding.ActivitySplashBinding
import com.lgcinterview.letsgetcountries.ui.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity(){

    companion object {
        const val SPLASH_TIME_OUT = 5000L
    }

    private val activityScope = CoroutineScope(Dispatchers.Main)

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            hideSystemUi()
        }

        supportActionBar?.hide()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        activityScope.launch{
            delay(SPLASH_TIME_OUT)
            startMainActivity()
        }

    }

    @Suppress("DEPRECATION")
    fun hideSystemUi(){
        with(window){
            requestFeature(Window.FEATURE_NO_TITLE)
            allowEnterTransitionOverlap = false
            allowReturnTransitionOverlap = false
            setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

            val systemUiFlags = View.SYSTEM_UI_FLAG_IMMERSIVE or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

            decorView.systemUiVisibility = systemUiFlags
        }
    }

    private fun startMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}