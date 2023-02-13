package m4_tecnica_de_programacao

fun main() {
    val pattern = """\(\d{2}\)\s9\d{4}-\d{4}""".toRegex()
    val input = "(11) 91234-5678"
    val isValid = pattern.matches(input)
    println(isValid)
}