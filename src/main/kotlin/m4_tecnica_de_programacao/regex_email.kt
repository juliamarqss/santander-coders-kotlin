package m4_tecnica_de_programacao

fun main() {
    val pattern = """\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}(?:\.[A-Za-z]{2})?\b""".toRegex()
    val input = "email@provedor.com"
    val isValid = pattern.matches(input)
    println(isValid)
}