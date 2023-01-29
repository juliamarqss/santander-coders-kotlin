import java.io.File

fun readCSv(fileName: String): List<List<String>> {
    val reader = File(fileName).bufferedReader()
    val header = reader.readLine()
    return reader.lineSequence()
        .filter { it.isNotBlank() }
        .map {
            it.split(',', ignoreCase = false)
        }.toList()
}
