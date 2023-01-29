package m2_poo.sistema_bancario
import java.text.NumberFormat
import java.util.*

interface Carteira {
    val senha: String
    val tipo: String
    val saldo: Double
    var extrato: String

    fun pagarBoleto(valor: Double)
}

open class CarteiraFisica : Carteira {
    override var senha: String = ""
    override var tipo: String = ""
    override var saldo: Double = 0.0
    override var extrato: String = ""

    fun depositar(valor: Double) {
        saldo += valor
        println("O valor de ${currencyFormatter(valor)} foi depositado na conta com sucesso!")
    }

    fun sacar(valor: Double) {
        saldo -= valor
        println("O valor de ${currencyFormatter(valor)} foi sacado com sucesso!")
    }

    override fun pagarBoleto(valor: Double) {
        saldo -= valor
        println("O valor de ${currencyFormatter(valor)} foi pago com sucesso!")
    }
}

open class CarteiraDigital : Carteira {
    override var senha: String = ""
    override var tipo: String = ""
    override var saldo: Double = 0.0
    override var extrato: String = ""

    fun transferenciaPix(valor: Double) {
        saldo -= valor
        println("O valor de ${currencyFormatter(valor)} foi transferido com sucesso!")
    }

    override fun pagarBoleto(valor: Double) {
        saldo -= valor
        println("O valor de ${currencyFormatter(valor)} foi pago com sucesso!")
    }

    fun investir(valor: Double) {
        saldo += valor
        println("O valor de ${currencyFormatter(valor)} foi investido com sucesso!")
    }

    fun guardar(valor: Double) {
        saldo += valor
        println("O valor de ${currencyFormatter(valor)} foi guardado com sucesso!")
    }
}

fun currencyFormatter(number: Double): String {
    val currencyInstance = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))
    return currencyInstance.format(number)
}