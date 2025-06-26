package com.example.quickmenu

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
import com.example.login.CadastroActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        val emailEditText = findViewById<EditText>(R.id.etEmail)
        val senhaEditText = findViewById<EditText>(R.id.etSenha)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val tvCadastroLink = findViewById<TextView>(R.id.tvCadastroLink)

        btnEntrar.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val senha = senhaEditText.text.toString().trim()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Entrando...", Toast.LENGTH_SHORT).show()
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

        tvCadastroLink.text = spannableString
        tvCadastroLink.movementMethod = LinkMovementMethod.getInstance()

    }
}