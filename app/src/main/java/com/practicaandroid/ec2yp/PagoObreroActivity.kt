package com.practicaandroid.ec2yp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PagoObreroActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_obrero)

        val etApellido = findViewById<EditText>(R.id.etApellido)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val spinnerCategoria = findViewById<Spinner>(R.id.spinnerCategoria)
        val etHorasTrabajadas = findViewById<EditText>(R.id.etHorasTrabajadas)
        val btnCalcularPago = findViewById<Button>(R.id.btnCalcularPago)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcularPago.setOnClickListener {
            val apellido = etApellido.text.toString()
            val nombre = etNombre.text.toString()
            val categoria = spinnerCategoria.selectedItem.toString()
            val horasTrabajadas = etHorasTrabajadas.text.toString().toIntOrNull() ?: 0

            val pago = Pago(apellido, nombre, categoria, horasTrabajadas)

            // Mostrar resultados
            tvResultado.text = """
                Obrero: $apellido $nombre
                Categoría: $categoria
                Horas Normales: ${pago.horasNormales}
                Horas Extras: ${pago.horasExtras}
                Costo Hora Normal: S/ ${pago.costoPorHora}
                Costo Hora Extra: S/ ${pago.costoHoraExtra}
                Importe Horas Normales: S/ ${pago.importeHorasNormales}
                Importe Horas Extras: S/ ${pago.importeHorasExtras}
                Valor Neto: S/ ${pago.valorNeto}
            """.trimIndent()
        }
    }
}

