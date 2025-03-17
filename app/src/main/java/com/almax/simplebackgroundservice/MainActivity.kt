package com.almax.simplebackgroundservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.almax.simplebackgroundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUi()
    }

    private fun setupUi() {
        binding.apply {
            btnStart.setOnClickListener {
                startService(Intent(this@MainActivity, BackgroundService::class.java))
            }

            btnStop.setOnClickListener {
                stopService(Intent(this@MainActivity, BackgroundService::class.java))
            }
        }
    }
}