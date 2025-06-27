package com.example.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityCadastroBinding // <<--- IMPORTANTE: Importe a classe de binding gerada

class CadastroActivity : AppCompatActivity() {

    // Declare a variável para a sua classe de binding
    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrarUsuario.setOnClickListener {
            val nomeUsuario = binding.etNomeUsuario.text.toString().trim()
            val email = binding.etEmailCadastro.text.toString().trim()
            val senha = binding.etSenhaCadastro.text.toString().trim()

            if (nomeUsuario.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Por favor, insira um e-mail válido.", Toast.LENGTH_SHORT).show()
            } else if (senha.length < 6) {
                Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Usuário '$nomeUsuario' cadastrado com o e-mail '$email'.", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}