package com.example.login.Auth

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
import androidx.navigation.fragment.findNavController
import com.example.login.R
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

        val navController = findNavController()

        binding.btnEntrar.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val senha = binding.etSenha.text.toString().trim()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()

                navController.navigate(R.id.action_loginFragment_to_usuarioFragment)
            }
        }

        // --- Lógica do Link de Cadastro (Mantida) ---
        val fullText = "Preencha com seus dados para realizar o cadastro"
        val spannableString = SpannableString(fullText)


        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                navController.navigate(R.id.action_loginFragment_to_cadastroFragment)
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
