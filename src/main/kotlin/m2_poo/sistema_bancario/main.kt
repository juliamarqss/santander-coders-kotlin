package m2_poo.sistema_bancario

const val LINHA = "--------------------------------------------------------------------------------"

fun main() {
    // CLIENTE NORMAL
    val clienteN = ClienteNormal(
        nome = "Julia",
        sobrenome = "Marques",
        cpf = "00000000000",
        senha = "123456",
        plano = Plano.NORMAL
    )

    println("""
        
Nome Completo: ${clienteN.nome} ${clienteN.sobrenome}
CPF: ${clienteN.cpf}
Senha: ${clienteN.senha}
Plano: ${clienteN.plano.tipo}
Saldo Atual: ${clienteN.carteiraFisica.saldo}
$LINHA
    """.trimIndent())

    with(clienteN.carteiraFisica){
        depositar(2500.00)
        println(LINHA)
        sacar(500.00)
        println(LINHA)
        println("Saldo atualizado: R$ $saldo")
        println(LINHA)
    }

    // CLIENTE DIGITAL
    val clienteD = ClienteDigital(
        nome = "Luna",
        sobrenome = "Lovegood",
        cpf = "11111111111",
        senha = "1789456",
        plano = Plano.DIGITAL
    )

    println("""
        
Nome Completo: ${clienteD.nome} ${clienteD.sobrenome}
CPF: ${clienteD.cpf}
Senha: ${clienteD.senha}
Plano: ${clienteD.plano.tipo}
Saldo Atual: ${clienteD.carteiraDigital.saldo}
$LINHA
    """.trimIndent())

    with(clienteD.carteiraDigital){
        this.guardar(10000.00)
        println(LINHA)
        this.transferenciaPix(500.00)
        println(LINHA)
        investir(2500.00)
        println(LINHA)
        pagarBoleto(200.00)
    }

    // CLIENTE PREMIUM
    val clienteP = ClientePremium(
        nome = "Ronald",
        sobrenome = "Weasley",
        cpf = "333333333333",
        senha = "123465852",
        plano = Plano.PREMIUM
    )

    println("""
        
Nome Completo: ${clienteP.nome} ${clienteP.sobrenome}
CPF: ${clienteP.cpf}
Senha: ${clienteP.senha}
Plano: ${clienteP.plano.tipo}
Saldo Atual(Carteira Digital): ${clienteP.carteiraDigital.saldo}
Saldo Atual(Carteira Física): ${clienteP.carteiraFisica.saldo}
$LINHA
    """.trimIndent())

    with(clienteP.carteiraDigital){
        guardar(50000.00)
        println(LINHA)
        transferenciaPix(5000.00)
        println(LINHA)
        investir(2500.00)
        println(LINHA)
        pagarBoleto(350.00)
    }
}