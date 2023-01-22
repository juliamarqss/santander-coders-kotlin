package poo

//private const val LINHA = "........."

//val menuInicial = """
//
//    Digite a ação desejada no Menu:
//
//    1${LINHA}Adicionar item
//    2${LINHA}Editar item
//    3${LINHA}Exibir itens em estoque
//    4${LINHA}Exibir todos os itens
//    0${LINHA}Fechar sistema
//""".trimIndent()


fun main() {
    val meuAquario = Aquario()
    meuAquario.adicionarPeixe("Peixe 1", "Azul", "Pequeno")
    meuAquario.adicionarPeixe("Peixe 2", "Vermelho", "Médio")
    meuAquario.alimentarPeixes()
    meuAquario.limparAquario()
    meuAquario.upgradeTamanho(5)
}

class Peixe(val nome: String, val cor: String, val tamanho: String)

class Aquario(var multiploDe: Int = 3) {
    var peixes = mutableListOf<Peixe>()
    var sujo = true

    fun adicionarPeixe(nome: String, cor: String, tamanho: String) {
        if (!sujo && peixes.size % multiploDe != 0) {
            peixes.add(Peixe(nome, cor, tamanho))
        } else {
            println("Não é possível adicionar peixes no momento.")
        }
    }

    fun alimentarPeixes() {
        val quantidade = (0..peixes.size).random()
        if (quantidade == peixes.size) {
            println("Sucesso, todos os peixes se alimentaram.")
        } else if (quantidade > 0) {
            println("Parcial, $quantidade peixes se alimentaram.")
        } else {
            println("Falha, nenhum peixe se alimentou.")
        }
    }

    fun limparAquario() {
        sujo = false
    }

    fun upgradeTamanho(multiploDe: Int) {
        this.multiploDe = multiploDe
    }
}
