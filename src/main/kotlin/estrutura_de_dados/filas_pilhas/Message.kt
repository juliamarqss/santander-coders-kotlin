package estrutura_de_dados.filas_pilhas
import java.util.LinkedList
import java.util.Queue
import kotlin.random.Random

/*
Temos um serviço de mensageria que ao receber uma nova mensagem a coloca numa fila e tenta enviar a mensagem ao destinatário, acontece que as vezes temos problemas ao tentar entregar a mensagem, por isso é necessário que tentemos entregar a mesma mensagemm até 3 vezes.

Implementar uma fila dentro do MessageBroker onde seja possível retentar o envio das mensagens por pelo menos 3 vezes, caso a terceira tentativa seja uma falha, descartar a mensagem.
 */

data class Message(
    val text: String,
    val recipient: String
)

class MessageBroker {
    private val messageSender = Random(1000)
    val queue: Queue<Message> = LinkedList()

    // Implementar maneira de processar a fila e de retentar o envio de uma mensagem que deu erro
    fun processFirstMessage() {
        val message =  queue.peek()

        message?.let{
            var attempts = 0

            while (!send(message)) {
                attempts++
                if (attempts == 3) {
                    break
                }
            }

            queue.poll()

            if (attempts < 3) {
                println(
                    """
                Mensagem enviada com sucesso:
                ${message.text}
            """.trimIndent()
                )
            } else {
                println(
                    """
                Falha ao enviar mensagem!
            """.trimIndent()
                )
            }
        }
    }

    // Retorna true ao conseguir enviar uma mensagem com sucesso e false se não conseguir
    private fun send(message: Message): Boolean {
        return messageSender.nextBoolean()
    }
}

fun main() {
    val broker = MessageBroker()
    val message1 = Message("Hello, Jennifer!", "Julia")
    val message2 = Message("What?!", "Anonymous")

    broker.queue.add(message1)
    broker.queue.add(message2)

    broker.processFirstMessage()
    broker.processFirstMessage()
}