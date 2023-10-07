package com.lans.task_android_fundamental

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lans.task_android_fundamental.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var appUsername: String = "admin"
    private var appPassword: String = "admin123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etUsername = binding.etUsername.text
        val etPassword = binding.etPassword.text

        val bundle = intent.extras
        if (bundle != null) {
            val user = bundle.getParcelable<User>("user")
            appUsername = user!!.username
            appPassword = user.password
        }

        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener {
            if (signin(etUsername.toString(), etPassword.toString())) {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("username", etUsername.toString())
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(
                    this@LoginActivity,
                    "Username or password was wrong",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun signin(username: String, password: String): Boolean {
        if (username.isEmpty()) {
            Toast.makeText(
                this@LoginActivity,
                "Username must be filled",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (password.isEmpty()) {
            Toast.makeText(
                this@LoginActivity,
                "Password must be filled",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        if (username != appUsername) {
            return false
        }

        if (password != appPassword) {
            return false
        }

        return true
    }
}