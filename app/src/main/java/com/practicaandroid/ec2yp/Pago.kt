package com.practicaandroid.ec2yp

class Pago(
    private val apellido: String,
    private val nombre: String,
    private val categoria: String,
    private val horasTrabajadas: Int
) {
    val costoPorHora: Double = when (categoria.uppercase()) {
        "A" -> 16.0
        "B" -> 15.0
        "C" -> 14.0
        "D" -> 12.0
        else -> 0.0
    }

    private val tasaExtra = 1.25
    private val horasMaximas = 48

    val horasNormales: Int
        get() = if (horasTrabajadas <= horasMaximas) horasTrabajadas else horasMaximas

    val horasExtras: Int
        get() = if (horasTrabajadas > horasMaximas) horasTrabajadas - horasMaximas else 0

    val costoHoraExtra: Double
        get() = costoPorHora * tasaExtra

    val importeHorasNormales: Double
        get() = horasNormales * costoPorHora

    val importeHorasExtras: Double
        get() = horasExtras * costoHoraExtra

    val valorNeto: Double
        get() = importeHorasNormales + importeHorasExtras
}
