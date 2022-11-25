package logica_de_programacao

/* Numa eleição existem três candidatos. Faça um programa que peça o número total de eleitores.
Peça para cada eleitor votar e ao final mostrar o número de votos de cada candidato e qual a
porcentagem de votos de cada um.

Candidato A - 300 votos (30%)
Candidato B - 200 votos (20%)
Candidato C - 500 votos (50%) */

fun main() {
    println("Informe o número total de eleitores:")
    val num = readln().toInt()
    var voters = num

    var a = 0
    var b = 0
    var c = 0

    do {
        println("Vote em um dos candidatos:\n[A]\n[B]\n[C]")
        val vote = readln().uppercase()
        when(vote) {
            "A" -> a++
            "B" -> b++
            "C" -> c++
            else -> println("Voto nulo!")
        }
        voters--
    } while (voters != 0)

    val divider = num * 100

    val resultA = a.toDouble() / divider
    val resultB = b.toDouble() / divider
    val resultC = c.toDouble() / divider

    println("Candidato A")
    println("Total de votos: $a votos [$resultA%]\n")
    println("Candidato B")
    println("Total de votos: $b votos [$resultB%]\n")
    println("Candidato C")
    println("Total de votos: $c votos [$resultC%]\n")
}