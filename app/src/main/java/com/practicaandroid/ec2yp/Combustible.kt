package com.practicaandroid.ec2yp

data class Combustible(
    val tipo: String,
    val precioPorGalon: Double
) {
    fun calcularImporte(galones: Double): Double {
        return galones * precioPorGalon
    }

    fun calcularDescuento(galones: Double): Double {
        return if (galones > 10) calcularImporte(galones) * 0.15 else 0.0
    }

    fun calcularValorNeto(galones: Double): Double {
        return calcularImporte(galones) - calcularDescuento(galones)
    }
}
