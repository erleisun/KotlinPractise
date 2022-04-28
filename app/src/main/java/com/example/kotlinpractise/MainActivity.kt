package com.example.kotlinpractise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kotlinpractise.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewMode: MainViewMode by lazy {
        ViewModelProvider(this).get(
            MainViewMode::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main2)
        navView.setupWithNavController(navController)

        initScribe()
    }

    private fun initScribe() {
        mainViewMode.myName.observe(this) {
            binding.button7.text = it
        }
    }
}