import java.util.Scanner

object InputReader {
    private val scanner = Scanner(System.`in`)

    fun readString(prompt: String): String {
        println(prompt)
        return scanner.nextLine()
    }


}