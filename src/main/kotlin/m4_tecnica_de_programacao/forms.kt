package m4_tecnica_de_programacao

fun main() {
    val nameRegex = "^[a-zA-Z\\s]+\$".toRegex()
    val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)\\.(.+)".toRegex()
    val passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\$*&@#])[0-9a-zA-Z\$*&@#]{8,}\$".toRegex()

/*    /^
    (?=.*\d)              // deve conter ao menos um dígito
    (?=.*[a-z])           // deve conter ao menos uma letra minúscula
    (?=.*[A-Z])           // deve conter ao menos uma letra maiúscula
    (?=.*[$*&@#])         // deve conter ao menos um caractere especial
    [0-9a-zA-Z$*&@#]{8,}  // deve conter ao menos 8 dos caracteres mencionados
    $/
*/

    val name = "John Doe"
    val email= "john.doe@example.com"
    val password = "P@ssword123"

    val nameMatch: Boolean = nameRegex.matches(name)
    val emailMatch: Boolean = emailRegex.matches(email)
    val passwordMatch: Boolean = passwordRegex.matches(password)

    if (nameMatch) {
        println("Valid name")
    } else {
        println("Invalid name")
    }

    if (emailMatch) {
        println("Valid email")
    } else {
        println("Invalid email")
    }

    if (passwordMatch) {
        println("Valid password")
    } else {
        println("Invalid password")
    }
}