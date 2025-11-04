package com.example.login.root

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.login.auth.AuthActivity

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3000L
    private val handler = Handler(Looper.getMainLooper())

    // VARIÁVEL DE CONTROLE
    private var isReady = false

    private val removeConditionCallback = Runnable {
        isReady = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)

        /*splashScreen.setKeepOnScreenCondition { !isReady }

        handler.postDelayed({

            val nextActivityClass = AuthActivity::class.java

            val intent = Intent(this, nextActivityClass).apply {
                // Flags para limpar a pilha (garante que não volte ao Splash)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }

            // Inicia a próxima Activity
            startActivity(intent)
            isReady = true
            finish()

        }, SPLASH_TIME_OUT)
        handler.postDelayed(removeConditionCallback, SPLASH_TIME_OUT)
    }*/
        val nextActivityClass = AuthActivity::class.java
        val intent = Intent(this, nextActivityClass).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
}