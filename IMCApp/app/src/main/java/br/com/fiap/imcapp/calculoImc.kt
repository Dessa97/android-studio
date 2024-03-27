package br.com.fiap.imcapp


import androidx.compose.ui.graphics.Color
import kotlin.math.pow


fun calcularIMC(altura: Double, peso: Double): Double {
    return peso / (altura / 100).pow(2.0)
}

fun classificacaoIMC(imc: Double): String {

    return if (imc < 18.5) {
        "Abaixo do peso"
    } else if (imc >= 18.5 && imc < 25.0) {
        "Peso Ideal"
    } else if (imc >= 25.0 && imc < 30.0) {
        "Levemente acima do peso"
    } else if (imc >= 30.0 && imc < 35.0) {
        "Obesidade Grau I"
    } else if (imc >= 35.0 && imc < 40.0) {
        "Obesidade Grau II"
    } else {
        "Obesidade Grau III"
    }
}

val redFiap = Color(0xFFED145B)
val greenColor = Color(0xFF008356)
val yellowColor = Color(0xfff6d64a)

fun classificacaoCor(imc: Double): Color {
    return if (imc < 18.5)
        redFiap
    else if (imc >= 18.5 && imc < 25.0) {
        greenColor
    } else if (imc >= 25.0 && imc < 30.0) {
        yellowColor
    } else if (imc >= 30.0 && imc < 35.0) {
        redFiap
    } else if (imc >= 35.0 && imc < 40.0) {
        redFiap
    } else {
        redFiap
    }
}


