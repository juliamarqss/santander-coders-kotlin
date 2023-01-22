package estrutura_de_dados.filas_pilhas
import java.util.*

/*
Interpretar expressões matemáticas não é uma tarefa trivial, por isso é comum transformamos expressões da forma como
conhecemos (3 + 4) em uma notação polonesa reversa, que nesse caso teria o formato: 3 4 +. Ao fazermos isso facilita
criamos um algoritmo para calcular o resultado da expressão.

Para fazer tal conversão existem alguns algoritmos diferentes, um deles é chamado Shunting Yard, você deve implementar
um conversor de notação utilizando o algoritmo de Shunting Yard simplificado, ou seja, ignorando a parte onde ele
aceita funções no meio da expressão. Esse conversor deve utilizar a estrutura de dados de pilha.

https://en.wikipedia.org/wiki/Shunting_yard_algorithm

https://en.wikipedia.org/wiki/Reverse_Polish_notation
 */

class ShuntingYard {
    val stack = Stack<Char>()

    fun convertNotation(expression: String): String {
        val output = StringBuilder()

        for (c in expression) {
            if (c.isDigit()) {
                output.append(c)
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c)
            } else if (c == ')') {
                output.append(stack.pop())
            }
        }

        while (!stack.empty()) {
            output.append(stack.pop())
        }

        return output.toString()
    }

}

fun main() {
    val shuntingYard = ShuntingYard()
    val result = shuntingYard.convertNotation("3 + 4")

    println(result)
}