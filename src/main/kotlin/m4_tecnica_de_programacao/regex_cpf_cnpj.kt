package m4_tecnica_de_programacao

fun main() {
    val cpfPattern = """\d{3}\.\d{3}\.\d{3}-\d{2}""".toRegex()
    val cnpjPattern = """\d{2}\.\d{3}\.\d{3}/\d{4}-\d{2}""".toRegex()

    val cpfInput = "123.456.789-10"
    val cnpjInput = "12.345.678/9012-34"

    val isValidCPF = cpfPattern.matches(cpfInput)
    val isValidCNPJ = cnpjPattern.matches(cnpjInput)

    println(isValidCPF)
    println(isValidCNPJ)
}