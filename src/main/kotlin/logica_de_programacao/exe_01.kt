package logica_de_programacao

// Faça um programa que leia 10 valores digitados pelo usuário e no final, escreva o maior e o menor valor lido.

fun main() {
    val listOfNumbers: MutableList<Int> = mutableListOf()
    var high = Int.MIN_VALUE
    var low = Int.MAX_VALUE

    while (listOfNumbers.size < 10) {
        println("Digite um número:")
        val value = readln().toInt()
        listOfNumbers.add(value)
    }

    for (number in listOfNumbers) {
        if (number > high) high = number
        if (number < low) low = number
    }

    println("Maior número é: $high \nMenor número é: $low")
}