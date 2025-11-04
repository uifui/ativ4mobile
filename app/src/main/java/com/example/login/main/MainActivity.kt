package com.example.login.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
// Importa o binding do layout da Activity (que agora deve conter apenas o FragmentContainerView)
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declaração do binding para o layout da Activity Hospedeira
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inicializa o View Binding para a Activity
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Encontrar o NavController
        // Obtém a referência ao NavHostFragment (FragmentContainerView)
        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.navHost.id) as NavHostFragment

        val navController = navHostFragment.navController

        // 3. Conectar a BottomNavigationView ao NavController
        // O Navigation Component usa automaticamente os IDs do menu para navegar
        // para os Fragments com IDs correspondentes no nav_main.xml.
        binding.navbar.setupWithNavController(navController)
    }
}
