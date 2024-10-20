package com.lozada.christopher.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Ejercicio02 : AppCompatActivity() {
    private lateinit var etNombreCliente: EditText
    private lateinit var etNumeroCliente: EditText
    private lateinit var etProductos: EditText
    private lateinit var etCiudad: EditText
    private lateinit var etDireccion: EditText
    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio02)

        initializeViews()
        setupListeners()
    }

    private fun initializeViews() {
        etNombreCliente = findViewById(R.id.etNombreCliente)
        etNumeroCliente = findViewById(R.id.etNumeroCliente)
        etProductos = findViewById(R.id.etProductos)
        etCiudad = findViewById(R.id.etCiudad)
        etDireccion = findViewById(R.id.etDireccion)
        btnRegistrar = findViewById(R.id.btnRegistrar)
    }

    private fun setupListeners() {
        btnRegistrar.setOnClickListener {
            if (validateInputs()) {
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("NOMBRE", etNombreCliente.text.toString())
                    putExtra("NUMERO", etNumeroCliente.text.toString())
                    putExtra("PRODUCTOS", etProductos.text.toString())
                    putExtra("CIUDAD", etCiudad.text.toString())
                    putExtra("DIRECCION", etDireccion.text.toString())
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(): Boolean {
        return etNombreCliente.text.isNotEmpty() &&
                etNumeroCliente.text.isNotEmpty() &&
                etProductos.text.isNotEmpty() &&
                etCiudad.text.isNotEmpty() &&
                etDireccion.text.isNotEmpty()
    }
}