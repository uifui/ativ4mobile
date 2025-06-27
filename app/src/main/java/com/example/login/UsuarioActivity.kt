package com.example.login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivityMainBinding
import com.example.login.databinding.ActivityUsuarioBinding

class UsuarioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.voltar.setOnClickListener {
            finish()
        }

        if (savedInstanceState == null) { // Isso faz com que a linha só rode quando abrir o app apenas
            binding.navbar.selectedItemId = R.id.person
        }
    }
}