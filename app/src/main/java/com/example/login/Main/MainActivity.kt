package com.example.login.Main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import com.example.login.R
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declaração do binding para o layout da Activity Hospedeira
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inicializa o View Binding para a Activity
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navbar) as NavHost // ID do NavHost na HomeActivity

        val navController = navHostFragment.navController

        // VINCULA A BOTTOM NAV BAR (que está no layout da HomeActivity)
        binding.navbar.setupWithNavController(navController)

        // Agora, ao clicar no ícone do carrinho na BottomNavigationView,
        // o usuário é levado para o CarrinhoFragment.
    }
}