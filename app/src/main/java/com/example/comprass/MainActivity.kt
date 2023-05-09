package com.example.comprass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comprass.data.local.helper.ComprasDatabase
import com.example.comprass.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var db :ComprasDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



    }
}