package com.example.login

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.login.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEntrar.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val senha = binding.etSenha.text.toString().trim()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()

                // ********** MUDANÇA AQUI **********
                // 1. Removemos o Intent para UsuarioActivity.
                // 2. Fazemos uma transação de Fragment para carregar o UsuarioFragment.
                parentFragmentManager
                    .beginTransaction()
                    // Substitui o LoginFragment pelo UsuarioFragment no contêiner
                    .replace(R.id.fragment_container, UsuarioFragment())
                    // Adicionamos à pilha para que o botão Voltar não feche o app,
                    // mas sim volte para a tela de Login (se desejado).
                    // Para evitar que o usuário volte ao Login após um login bem-sucedido,
                    // NÃO se deve adicionar à Back Stack aqui.
                    .commit()
                // Se desejar limpar a Back Stack completamente antes de ir para o usuário (melhor para login):
                // parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }

        // --- Lógica do Link de Cadastro (Mantida) ---
        val fullText = "Preencha com seus dados para realizar o cadastro"
        val spannableString = SpannableString(fullText)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, CadastroFragment())
                    // Mantém na Back Stack para poder voltar do Cadastro para o Login
                    .addToBackStack(null)
                    .commit()
            }
        }

        val startIndex = fullText.indexOf("cadastro")
        if (startIndex != -1) {
            val endIndex = startIndex + "cadastro".length
            spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        binding.tvCadastro.text = spannableString
        binding.tvCadastro.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
