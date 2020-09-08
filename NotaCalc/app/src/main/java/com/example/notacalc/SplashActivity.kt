package com.example.notacalc

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler


class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({ // Esse método será executado sempre que o timer acabar
            // E inicia a activity principal
            val i = Intent(
                this@SplashActivity,
                MainActivity::class.java
            )
            startActivity(i)

            // Fecha esta activity
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        // Timer da splash screen
        private const val SPLASH_TIME_OUT = 2000
    }
}