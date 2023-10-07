package com.lans.task_android_fundamental

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lans.task_android_fundamental.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etName = binding.etName.text
        val etUsername = binding.etUsername.text
        val etPassword = binding.etPassword.text
        val etConfirmPassword = binding.etConfirmPassword.text
        val etEmail = binding.etEmail.text

        binding.tvSignIn.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnSignUp.setOnClickListener {
            signup(
                etName.toString(),
                etUsername.toString(),
                etPassword.toString(),
                etConfirmPassword.toString(),
                etEmail.toString()
            )

            Toast.makeText(
                this@RegisterActivity,
                "User registered successfully",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun signup(
        name: String,
        username: String,
        password: String,
        confirmPassword: String,
        email: String
    ) {
        if (name.isEmpty()) {
            Toast.makeText(
                this@RegisterActivity,
                "Name must be filled",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (username.isEmpty()) {
            Toast.makeText(
                this@RegisterActivity,
                "Username must be filled",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (password.isEmpty()) {
            Toast.makeText(
                this@RegisterActivity,
                "Password must be filled",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (confirmPassword.isEmpty()) {
            Toast.makeText(
                this@RegisterActivity,
                "Confirm password must be filled",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (email.isEmpty()) {
            Toast.makeText(
                this@RegisterActivity,
                "Email must be filled",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
        intent.putExtra("user", User(username, password))
        startActivity(intent)
        finish()
    }
}