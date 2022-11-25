package logica_de_programacao

// Faça um algoritmo para ler 15 números e armazenar em uma lista.

/* Após a leitura total dos 15 números, o algoritmo deve escrever esses 15 números
lidos na ordem inversa da qual foi declarado. */

fun main() {
    val listOfNumbers: MutableList<Int> = mutableListOf()

    while (listOfNumbers.size < 15) {
        println("Digite um número:")
        val value = readln().toInt()
        listOfNumbers.add(value)
    }

    println(listOfNumbers.reversed())
}