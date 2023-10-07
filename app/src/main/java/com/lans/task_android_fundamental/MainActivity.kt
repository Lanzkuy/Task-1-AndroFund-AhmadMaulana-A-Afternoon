package com.lans.task_android_fundamental

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lans.task_android_fundamental.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val welcome = "Welcome, " + intent.getStringExtra("username").toString()
        binding.tvWelcome.text = welcome

        binding.ivLogout.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnFirst.setOnClickListener {
            replaceFragment(FirstFragment())
        }

        binding.btnSecond.setOnClickListener {
            replaceFragment(SecondFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment, null)
            .commit()
    }
}