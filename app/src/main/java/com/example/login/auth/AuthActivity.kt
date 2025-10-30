package com.example.login.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.login.R
import com.example.login.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_QuickMenu)
        super.onCreate(savedInstanceState)

        installSplashScreen()

        // Inflar o layout usando o View Binding
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}