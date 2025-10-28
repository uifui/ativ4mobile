package com.example.login.Auth

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.example.login.R
import com.example.login.databinding.ActivityAuthBinding
import com.example.login.databinding.ActivityMainBinding

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