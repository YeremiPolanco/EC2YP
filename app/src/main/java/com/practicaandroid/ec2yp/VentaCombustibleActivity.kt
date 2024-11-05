package com.practicaandroid.ec2yp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class VentaCombustibleActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venta_combustible)

        val etApellido = findViewById<EditText>(R.id.etApellido)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val spnTipoCombustible = findViewById<Spinner>(R.id.spnTipoCombustible)
        val etGalones = findViewById<EditText>(R.id.etGalones)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Configuración del Spinner con tipos de combustibles
        val tiposCombustible = listOf(
            Combustible("Gasolina 84", 13.50),
            Combustible("Gasolina 90", 15.70),
            Combustible("Gasolina 95", 20.70),
            Combustible("Gasolina", 12.00)
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposCombustible.map { it.tipo })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnTipoCombustible.adapter = adapter

        // Cálculo y resultados
        btnCalcular.setOnClickListener {
            val apellido = etApellido.text.toString()
            val nombre = etNombre.text.toString()
            val galones = etGalones.text.toString().toDoubleOrNull() ?: 0.0
            val tipoCombustibleSeleccionado = tiposCombustible[spnTipoCombustible.selectedItemPosition]

            val importe = tipoCombustibleSeleccionado.calcularImporte(galones)
            val descuento = tipoCombustibleSeleccionado.calcularDescuento(galones)
            val valorNeto = tipoCombustibleSeleccionado.calcularValorNeto(galones)

            tvResultado.text = """
                Cliente: $apellido $nombre
                Importe: S/ $importe
                Descuento: S/ $descuento
                Valor Neto: S/ $valorNeto
            """.trimIndent()
        }
    }
}
