package com.example.login

import com.example.login.R
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.login.CadastroActivity
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val senha = binding.etSenha.text.toString().trim()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Entrando...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, UsuarioActivity::class.java)
                startActivity(intent)
            }
        }

        val fullText = "Preencha com seus dados para realizar o cadastro"
        val spannableString = SpannableString(fullText)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@MainActivity, CadastroActivity::class.java)
                startActivity(intent)
            }
        }

        val startIndex = fullText.indexOf("cadastro")
        if (startIndex != -1) {
            val endIndex = startIndex + "cadastro".length
            spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        // Use binding para acessar tvCadastroLink
        binding.tvCadastro.text = spannableString
        binding.tvCadastro.movementMethod = LinkMovementMethod.getInstance()
    }
}