package estrutura_de_dados.listas

/*
Dado a estrutura de lista ligada que construímos em sala, adicionar:

Método de busca por um valor específico
Otimização para termos a adição de um nó ao final de O(1), ou seja, será necessário manter uma referência para o último elemento da lista
 */

data class Node<T>(
    var value: T,
    var next: Node<T>?
)

data class LinkedList2<T>(var head: Node<T>? = null, var tail:  Node<T>? = null) {
    fun add(value: T) {
        val newNode = Node(value = value, null)

        if (head == null) {
            head = newNode
            tail = newNode
            return
        } else {
            val current = tail
            current?.next = newNode
            tail = newNode
        }
    }


    fun searchValue(value: T):Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null) {
            if (currentNode.value == value){
                return currentNode
            }
            currentNode = currentNode.next
            currentIndex++
        }
        return null
    }

    fun remove(value: T): Boolean {
        if (head?.value == value) {
            head = head?.next
            return true
        }
        var current = head?.next
        var previous = head

        while(current != null && current.value != value) {
            previous = current
            current = current.next
        }

        if (current != null) {
            previous?.next = current.next
            return true
        }

        return false
    }

    fun show() {
        var current = head
        if (current == null) {
            println("Lista vazia")
            return
        }

        while(current != null) {
            println(current.value)
            current = current.next
        }
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}

fun main() {
    val list = LinkedList2<Int>()

    println("List is empty: ${list.isEmpty()}")

    list.add(1)
    list.add(3)
    list.add(8)

    list.show()

    val searchNode = list.searchValue(3)?.value
    println("Search value: $searchNode")

    list.add(11)
    list.remove(8)
    list.show()

}