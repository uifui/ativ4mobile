package com.example.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
// Importa o binding do layout da Activity (que agora deve conter apenas o FragmentContainerView)
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declaração do binding para o layout da Activity Hospedeira
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instala a splash screen (mantido do código original)
        installSplashScreen()

        // 1. Inicializa o View Binding para a Activity
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
