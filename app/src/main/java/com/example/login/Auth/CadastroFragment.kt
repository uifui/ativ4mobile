package com.example.login.Auth

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment // Alterado de AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.login.R

import com.example.login.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() { // Herdar de Fragment

    // View Binding: Variável nullable (com _) para evitar vazamento de memória
    private var _binding: FragmentCadastroBinding? = null
    // Acesso seguro ao binding (não-nulo)
    private val binding get() = _binding!!

    // 1. Inflar o layout (substitui onCreate e setContentView)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar o layout
        _binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root // Retorna a View raiz
    }

    // 2. Configurar a lógica da View após ela ser criada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        binding.btnCadastrarUsuario.setOnClickListener {
            val nomeUsuario = binding.etNomeUsuario.text.toString().trim()
            val email = binding.etEmailCadastro.text.toString().trim()
            val senha = binding.etSenhaCadastro.text.toString().trim()

            // NOTA: Em Fragments, use 'requireContext()' ou 'activity' para o Context
            if (nomeUsuario.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(requireContext(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(requireContext(), "Por favor, insira um e-mail válido.", Toast.LENGTH_SHORT).show()
            } else if (senha.length < 6) {
                Toast.makeText(requireContext(), "A senha deve ter pelo menos 6 caracteres.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Usuário '$nomeUsuario' cadastrado com o e-mail '$email'.",
                    Toast.LENGTH_LONG
                ).show()

                //navController.navigate(R.id.action_cadastroFragment_to_loginFragment)


            }
        }
    }

    // 3. Limpar a referência de binding para evitar vazamento de memória
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}