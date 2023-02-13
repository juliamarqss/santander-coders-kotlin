package m4_tecnica_de_programacao

fun main() {
    val pattern = """R\$\s(\d{1,3}(\.\d{3})*|\d+)(,\d{2})?""".toRegex()
    val input = "R$ 7,50"
    val isValid = pattern.matches(input)
    println(isValid)
}