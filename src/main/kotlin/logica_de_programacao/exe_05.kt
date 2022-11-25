package logica_de_programacao

/* Faça um programa que gera uma lista dos números primos existentes
entre 1 e um número inteiro informado pelo usuário. */

fun main() {
    println("Digite um máximo:")
    val num = readln().toInt()

    for (i in 2..num){
        if ((i%2!=0) && (i%3!=0) && (i%5!=0)) {
            println(i)
        }
        if (i == 2) {
            println(i)
        }
        if (i == 5) {
            println(i)
        }
    }
}

