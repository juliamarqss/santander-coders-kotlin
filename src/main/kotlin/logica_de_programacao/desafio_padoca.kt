package logica_de_programacao

private const val FINALIZAR = 0
private const val PAES = 1
private const val SALGADOS = 2
private const val DOCES = 3
private const val LINHA = "........."

// PAES
const val produtoPaoFrances = "Pão Francês"
const val produtoPaoDeLeite = "Pão de Leite"
const val produtoPaoDeMilho = "Pão de Milho"

const val valorPaoFrances = 0.60
const val valorPaoDeLeite = 0.40
const val valorPaoDeMilho = 0.50

val paes: List<Pair<String, Double>> = listOf(
    Pair(produtoPaoFrances, valorPaoFrances), // INDEX - 0
    Pair(produtoPaoDeLeite, valorPaoDeLeite), // INDEX - 1
    Pair(produtoPaoDeMilho, valorPaoDeMilho), // INDEX - 2
)

// SALGADOS
const val produtoCoxinha = "Coxinha"
const val produtoEsfiha = "Esfiha"
const val produtoPaoDeQueijo = "Pão de Queijo"

const val valorCoxinha = 5.00
const val valorEsfiha = 6.00
const val valorPaoDeQueijo = 3.00

val salgados: List<Pair<String, Double>> = listOf(
    Pair(produtoCoxinha, valorCoxinha),
    Pair(produtoEsfiha, valorEsfiha),
    Pair(produtoPaoDeQueijo, valorPaoDeQueijo),
)

// DOCES
const val produtoCarolina = "Carolina"
const val produtoPudim = "Pudim"
const val produtoBrigadeiro = "Brigadeiro"

const val valorCarolina = 1.50
const val valorPudim = 4.00
const val valorBrigadeiro = 2.00

val doces: List<Pair<String, Double>> = listOf(
    Pair(produtoCarolina, valorCarolina),
    Pair(produtoPudim, valorPudim),
    Pair(produtoBrigadeiro, valorBrigadeiro),
)

// MENUS
val menuPaes = """
        1 - $produtoPaoFrances...........R$ $valorPaoFrances
        2 - $produtoPaoDeLeite..........R$ $valorPaoDeLeite
        3 - $produtoPaoDeMilho..........R$ $valorPaoDeMilho
        0 - Voltar
    """.trimIndent()

val menuSalgados = """
        1 - $produtoCoxinha...........R$ $valorCoxinha
        2 - $produtoEsfiha..........R$ $valorEsfiha
        3 - $produtoPaoDeQueijo..........R$ $valorPaoDeQueijo
        0 - Voltar
    """.trimIndent()

val menuDoces = """
        1 - $produtoCarolina...........R$ $valorCarolina
        2 - $produtoPudim..........R$ $valorPudim
        3 - $produtoBrigadeiro..........R$ $valorBrigadeiro
        0 - Voltar
    """.trimIndent()

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
                val totalComDesconto = desconto(cupom)
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
            PAES -> selecionaProduto(menuSelecionado = menuPaes, produtos = paes)
            SALGADOS -> selecionaProduto(menuSelecionado = menuSalgados, produtos = salgados)
            DOCES -> selecionaProduto(menuSelecionado = menuDoces, produtos = doces)
            else -> Unit
        }
    } while (categoria != FINALIZAR)
}

fun selecionaProduto(
    menuSelecionado: String, produtos: List<Pair<String, Double>>
) {
    do {
        println(menuSelecionado)
        val produtoSelecionado = readln().toInt() // valor atual -> 1 (corresponde ao pao frances)

        for ((i, produto) in produtos.withIndex()) {
            if (i.inc() == produtoSelecionado) {
                selecionaQuantidadeDoProduto(produto)
                break
            }
        }


    } while (produtoSelecionado != 0)
}

fun selecionaQuantidadeDoProduto(produto: Pair<String, Double>) {
    println("Digite a quantidade:")
    val quantidade = readln().toInt()
    val totalItem = quantidade * produto.second
    val item =
        itemComanda(produto = produto.first, quantidade = quantidade, valorUnitario = produto.second, total = totalItem)
    itensComanda.add(item)
    totalDaComanda += totalItem
}

fun itemComanda(
    produto: String,
    quantidade: Int,
    valorUnitario: Double,
    total: Double,
): String = "${itensComanda.size.inc()}$LINHA$produto$LINHA$quantidade$LINHA$valorUnitario${LINHA}R$$total"

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
