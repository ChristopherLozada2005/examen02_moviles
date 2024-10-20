package com.lozada.christopher.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var tvNombreCliente: TextView
    private lateinit var tvNumeroCliente: TextView
    private lateinit var tvProductos: TextView
    private lateinit var tvUbicacion: TextView
    private lateinit var btnLlamar: ImageButton
    private lateinit var btnWhatsapp: ImageButton
    private lateinit var btnMaps: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initializeViews()

        setData()

        setupListeners()
    }

    private fun initializeViews() {
        tvNombreCliente = findViewById(R.id.tvNombreCliente)
        tvNumeroCliente = findViewById(R.id.tvNumeroCliente)
        tvProductos = findViewById(R.id.tvProductos)
        tvUbicacion = findViewById(R.id.tvUbicacion)
        btnLlamar = findViewById(R.id.btnLlamar)
        btnWhatsapp = findViewById(R.id.btnWhatsapp)
        btnMaps = findViewById(R.id.btnMaps)
    }

    private fun setData() {
        tvNombreCliente.text = intent.getStringExtra("NOMBRE")
        tvNumeroCliente.text = intent.getStringExtra("NUMERO")
        tvProductos.text = intent.getStringExtra("PRODUCTOS")
        tvUbicacion.text = intent.getStringExtra("DIRECCION")
    }

    private fun setupListeners() {
        btnLlamar.setOnClickListener {
            val intentLlamar = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${tvNumeroCliente.text}")
            }
            startActivity(intentLlamar)
        }

        btnWhatsapp.setOnClickListener {
            val message = "Hola ${tvNombreCliente.text}, Tus productos: ${tvProductos.text} están en camino a la dirección: ${tvUbicacion.text}"
            val intentWhatsapp = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://api.whatsapp.com/send?phone=${tvNumeroCliente.text}&text=${Uri.encode(message)}")
            }
            startActivity(intentWhatsapp)
        }

        btnMaps.setOnClickListener {
            val intentMaps = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=${Uri.encode(tvUbicacion.text.toString())}")
            }
            startActivity(intentMaps)
        }
    }
}
