package com.practicaandroid.ec2yp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVentaCombustible = findViewById<Button>(R.id.btnVentaCombustible)
        btnVentaCombustible.setOnClickListener {
            startActivity(Intent(this, VentaCombustibleActivity::class.java))
        }

        val btnPagoObrero = findViewById<Button>(R.id.btnPagoObrero)
        btnPagoObrero.setOnClickListener {
            startActivity(Intent(this, PagoObreroActivity::class.java))
        }
    }
}