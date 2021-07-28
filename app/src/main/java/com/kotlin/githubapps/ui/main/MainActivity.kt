package com.kotlin.githubapps.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.githubapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // implement viewbinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // implement viewbinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}