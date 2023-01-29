package m2_poo

private const val FINALIZAR = 0
private const val PAES = 1
private const val SALGADOS = 2
private const val DOCES = 3
private const val LINHA = "........."

val paes: List<Pair<String, Double>> = listOf(
    Pair(Menu.PAOFRANCES.nome, Menu.PAOFRANCES.valor), // INDEX - 0
    Pair(Menu.PAODELEITE.nome, Menu.PAODELEITE.valor), // INDEX - 1
    Pair(Menu.PAODEMILHO.nome, Menu.PAODEMILHO.valor), // INDEX - 2
)

val salgados: List<Pair<String, Double>> = listOf(
    Pair(Menu.COXINHA.nome, Menu.COXINHA.valor),
    Pair(Menu.ESFIHA.nome, Menu.ESFIHA.valor),
    Pair(Menu.PAODEQUEIJO.nome, Menu.PAODEQUEIJO.valor),
)

val doces: List<Pair<String, Double>> = listOf(
    Pair(Menu.CAROLINA.nome, Menu.CAROLINA.valor),
    Pair(Menu.PUDIM.nome, Menu.PUDIM.valor),
    Pair(Menu.BRIGADEIRO.nome, Menu.BRIGADEIRO.valor),
)


val categorias = """
    Digite a opção desejada no Menu:
    1..................Pães
    2..............Salgados
    3.................Doces
    0......Finalizar compra
""".trimIndent()

// CUPONS DE DESCONTOS
private const val PADOCA5 = "5PADOCA"
private const val PADOCA10 = "10PADOCA"
private const val PADOCA50 = "5OFF"

val itensComanda = mutableListOf<String>()
var totalDaComanda: Double = 0.0

val padoca = EPadoca()

fun main() {
    do {
        var finalizarCompra = "S"
        ePadoca()

        if (itensComanda.isEmpty()) {
            println("Deseja mesmo finalizar a compra? (S/N)")
            finalizarCompra = readln().uppercase()
        } else {
            itensComanda.forEach { item -> println(item)}
            println("Valor total R$$totalDaComanda")

            println("Gostaria de aplicar algum cupom? (S/N)")
            val solicitacao = readln().uppercase()

            if (solicitacao.equals("S", ignoreCase = true)) {
                println("Digite o nome do cupom: ")
                val cupom = readln().uppercase()
                val totalComDesconto = padoca.desconto(cupom)
                println("Valor total com desconto aplicado R$$totalComDesconto")
            }
        }
    } while (finalizarCompra != "S")
}

fun ePadoca() {
    println("Bem Vindo à padaria E-Padoca!")
    do {
        println(categorias)

        val categoria = readln().toInt()

        when (categoria) {
            PAES -> padoca.selecionaProduto(categoria = 1 , produtos = paes)
            SALGADOS -> padoca.selecionaProduto(categoria = 2, produtos = salgados)
            DOCES -> padoca.selecionaProduto(categoria = 3, produtos = doces)
            else -> Unit
        }
    } while (categoria != FINALIZAR)
}

class EPadoca() {
    fun selecionaProduto(
        categoria: Int, produtos: List<Pair<String, Double>>
    ) {
        do {
            Menu.selecionarCategoria(categoria)
            val produtoSelecionado = readln().toInt()

            for ((i, produto) in produtos.withIndex()) {
                if (i.inc() == produtoSelecionado) {
                    selecionaQuantidadeDoProduto(produto)
                    break
                }
            }
        } while (produtoSelecionado != 0)
    }

    fun selecionaQuantidadeDoProduto(produto: Pair< String, Double>) {
        println("Digite a quantidade:")
        val quantidade = readln().toInt()
        val totalItem = quantidade * produto.second
        val item = itemComanda(produto = produto.first, quantidade = quantidade, valorUnitario = produto.second, total = totalItem)
        itensComanda.add(item)
        totalDaComanda += totalItem
    }

    fun itemComanda(
        produto: String,
        quantidade: Int,
        valorUnitario: Double,
        total: Double,
    ): String = "${itensComanda.size.inc()}${LINHA}$produto${LINHA}$quantidade${LINHA}$valorUnitario${LINHA}R$$total"

    fun desconto(cupom: String): Double {
        val desconto5 = totalDaComanda * 0.95
        val desconto10 = totalDaComanda * 0.9
        val desconto50 = if (totalDaComanda < 5.0) {
            1.0
        } else {
            totalDaComanda - 5
        }

        var desconto: Double
        var selecionado: Boolean

        do {
            selecionado = true
            desconto = when (cupom) {
                PADOCA5 -> desconto5
                PADOCA10 -> desconto10
                PADOCA50 -> desconto50
                else -> {
                    selecionado = false
                    println("Cupom inválido!")
                    1.0
                }
            }
        } while(!selecionado)
        return desconto
    }
}


enum class Menu(val nome: String, val valor: Double, val idx: Int, val categoria: Int) {
    PAOFRANCES(nome = "Pão Francês", valor = 0.60, idx = 1, categoria = 1),
    PAODELEITE(nome = "Pão de Leite", valor = 0.40, idx = 2, categoria = 1),
    PAODEMILHO(nome = "Pão de Milho", valor = 0.50, idx = 3, categoria = 1),
    COXINHA(nome = "Coxinha", valor = 5.00, idx = 1, categoria = 2),
    ESFIHA(nome = "Esfiha", valor = 6.00, idx = 2, categoria = 2),
    PAODEQUEIJO(nome = "Pão de Queijo", valor = 3.00, idx = 3, categoria = 2),
    CAROLINA(nome = "Carolina", valor = 1.50, idx = 1, categoria = 3),
    PUDIM(nome = "Pudim", valor = 4.50, idx = 2, categoria = 3),
    BRIGADEIRO(nome = "Brigadeiro", valor = 2.00, idx = 3, categoria = 3);

    companion object {
        fun selecionarCategoria(i: Int) {
            val filter = Menu.values().filterNot {
                it.categoria != i
            }
            filter.forEach {
                println("${it.idx} ${it.nome}${LINHA}R$ ${it.valor}")
            }
            println("0 - Voltar")
        }
    }
}