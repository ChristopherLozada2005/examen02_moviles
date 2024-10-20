package com.lozada.christopher.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lozada.christopher.laboratoriocalificado02.databinding.ActivityEjercicio01Binding

class Ejercicio01 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            binding.viewGreen.visibility = View.VISIBLE
        }

        binding.btnHide.setOnClickListener {
            binding.viewGreen.visibility = View.GONE
        }
    }
}