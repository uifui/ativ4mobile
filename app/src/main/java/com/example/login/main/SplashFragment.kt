package com.example.login.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({

            if (isAdded && findNavController().currentDestination?.id == R.id.splashFragment) {

                findNavController().navigate(R.id.usuarioFragment)
            }

        }, 3000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Limpa a referência de binding para evitar vazamento de memória (memory leak)
        _binding = null
    }
}