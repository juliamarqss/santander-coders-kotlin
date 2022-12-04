package poo

private const val FINALIZAR = 0
private const val ADD_ITEM = 1
private const val EDITAR_ITEM = 2
private const val EXIBIR_ESTOQUE = 3
private const val EXIBIR_TODOS = 4
private const val LINHA = "........."

val menuInicial = """
    
    Digite a ação desejada no Menu:
    
    1${LINHA}Adicionar item
    2${LINHA}Editar item
    3${LINHA}Exibir itens em estoque
    4${LINHA}Exibir todos os itens
    0${LINHA}Fechar sistema
""".trimIndent()


fun main() {
    menuPrincipal()
}

fun menuPrincipal() {
    val estoque = Estoque()
    do {
        println(menuInicial)
        val acao = readln().toInt()

        when(acao) {
            ADD_ITEM -> estoque.addProduto()
            EDITAR_ITEM -> estoque.editarProduto()
            EXIBIR_ESTOQUE -> estoque.exibirEstoque()
            EXIBIR_TODOS -> estoque.exibirTodos()
            else -> Unit
        }
    } while (acao != FINALIZAR)
}

class Estoque {
    private val listaDeProdutos = mutableListOf<Triple<Int, String, Int>>()
    private var id = 0

    fun addProduto() {
        println("\nVocê entrou em 'ADICIONAR PRODUTO'\n")
        println("Nome da produto:")
        val produto = readln()

        println("Quantidade:")
        val quantidade = readln().toInt()

        if (quantidade > 999) throw LimiteEstoqueMaxException()
        if (quantidade < 0) throw LimiteEstoqueMinException()

        listaDeProdutos.add(Triple(++id, produto, quantidade))
        println("\nProduto adicionado com sucesso!")
    }

    fun editarProduto() {
        if(listaDeProdutos.isEmpty()) {
            println("""
            
            Não é possível realizar essa ação.
            É necessário acrescentar algum produto no sistema!
            
        """.trimIndent())
        } else {
            println("\nVocê entrou em 'EDITAR PRODUTO'")
            exibirTodos()

            println("\nInforme o ID do produto a ser editado:")
            val id = readln().toInt()

            if(id > listaDeProdutos.size) {
                println("\nID não encontrado!")
            } else {
                println("""
                    
                DADOS DO PRODUTO:
                1) Nome → ${listaDeProdutos[id - 1].second}
                2) Quantidade → ${listaDeProdutos[id - 1].third}
                
                Digite o número do campo para editar:
            """.trimIndent())
                val campo = readln().toInt()

                val idOrigem = listaDeProdutos[id - 1].first
                val nomeOrigem = listaDeProdutos[id - 1].second
                val qtdOrigem = listaDeProdutos[id - 1].third

                when(campo){
                    1 -> {
                        println("\nDigite um novo valor para o campo 'Nome':")
                        val novoNome = readln()
                        listaDeProdutos[id - 1] = Triple(first = idOrigem, second = novoNome, third = qtdOrigem)

                        println("\nNome Atual → ${listaDeProdutos[id - 1].second}")
                        println("\nProduto editado com sucesso!")
                    }
                    2 -> {
                        println("\nDigite um novo valor para o campo 'Quantidade':")
                        val novaQtd = readln().toInt()

                        if (novaQtd > 999) throw LimiteEstoqueMaxException()
                        if (novaQtd < 0) throw LimiteEstoqueMinException()

                        listaDeProdutos[id - 1] = Triple(first = idOrigem, second = nomeOrigem, third = novaQtd)

                        println("\nQuantidade Atual → ${listaDeProdutos[id - 1].third}")
                        println("\nProduto editado com sucesso!")
                    }
                    else -> Unit
                }
            }
        }
    }

    fun exibirEstoque() {
        val estoque = listaDeProdutos.filterNot {
            it.third == 0
        }
        println("\nLISTA DE PRODUTOS EM ESTOQUE:")
        println("ID | PRODUTO | QUANTIDADE")
        estoque.forEach {
            println("#${it.first} | ${it.second} | ${it.third}")
        }
    }

    fun exibirTodos() {
        println("\nLISTA DE PRODUTOS:")
        println("ID | PRODUTO | QUANTIDADE")
        listaDeProdutos.forEach {
            println("#${it.first} | ${it.second} | ${it.third}")
        }
    }
}

// Erros
class LimiteEstoqueMaxException : Exception() {
    override fun getLocalizedMessage(): String {
        return "Erro: Quantidade maior que 999. (Quantidade Máxima = 999)"
    }
}

class LimiteEstoqueMinException : Exception() {
    override fun getLocalizedMessage(): String {
        return "Erro: Quantidade menor que 0. (Quantidade Mínima = 0)"
    }
}
