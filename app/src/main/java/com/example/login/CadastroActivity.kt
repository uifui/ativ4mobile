package com.example.login
import com.example.login.R
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val nomeUsuarioEditText = findViewById<EditText>(R.id.etNomeUsuario)
        val emailEditText = findViewById<EditText>(R.id.etEmailCadastro)
        val senhaEditText = findViewById<EditText>(R.id.etSenhaCadastro)
        val btnCadastrarUsuario = findViewById<Button>(R.id.btnCadastrarUsuario)


        btnCadastrarUsuario.setOnClickListener {

            val nomeUsuario = nomeUsuarioEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val senha = senhaEditText.text.toString().trim()


            if (nomeUsuario.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Por favor, insira um e-mail válido.", Toast.LENGTH_SHORT).show()
            } else if (senha.length < 6) {
                Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres.", Toast.LENGTH_SHORT).show()
            }
            else {

                Toast.makeText(this, "Usuário '$nomeUsuario' cadastrado com o e-mail '$email'.", Toast.LENGTH_LONG).show()

            }
        }
    }
}
