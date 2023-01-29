package m2_poo.sistema_bancario

enum class Plano(var tipo: String){
    NORMAL(tipo = "Normal"),
    DIGITAL(tipo = "Digital"),
    PREMIUM(tipo = "Premium")
}

internal abstract class PessoaFisica(
    open var nome: String,
    open var sobrenome: String,
    open var cpf: String,
)

internal abstract class Cliente(
    override var nome: String,
    override var sobrenome: String,
    override var cpf: String,
    open var senha: String,
    open var plano: Plano) :
    PessoaFisica(nome, sobrenome, cpf)

internal class ClienteNormal(
    override var nome: String,
    override var sobrenome: String,
    override var cpf: String,
    override var senha: String,
    override var plano: Plano) :
    Cliente(nome, sobrenome, cpf, senha, plano) {
        val carteiraFisica = CarteiraFisica()
    }

internal class ClienteDigital(
    override var nome: String,
    override var sobrenome: String,
    override var cpf: String,
    override var senha: String,
    override var plano: Plano) :
    Cliente(nome, sobrenome, cpf, senha, plano) {
    val carteiraDigital = CarteiraDigital()
}

internal class ClientePremium(
    override var nome: String,
    override var sobrenome: String,
    override var cpf: String,
    override var senha: String,
    override var plano: Plano) :
    Cliente(nome, sobrenome, cpf, senha, plano) {
    val carteiraFisica = CarteiraFisica()
    val carteiraDigital = CarteiraDigital()
}