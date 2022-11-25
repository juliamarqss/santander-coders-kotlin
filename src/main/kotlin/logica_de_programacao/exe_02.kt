package logica_de_programacao

// Escreva um algoritmo que receba um número e imprima a tabuada dele (de 1 a 10)

fun main() {
    println("Digite um número:")
    val num = readln().toInt()

    for (i in 1..10) {
        val result = num * i
        println("$i x $num = $result")
    }
}