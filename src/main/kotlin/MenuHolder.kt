
import java.util.Scanner

class MenuHolder<T> {
    private val scanner = Scanner(System.`in`)

    fun create(name: String, collection: MutableList<T>, smth: (String) -> T) {
        if (name.isNotEmpty()) {
            collection.add(smth(name))

        } else {
            println("Название не может быть пустым.")

        }
    }

    fun displayMainMenu() {
        println("Главное меню:")
        println("1. Архивы")
        println("2. Выход")
    }


    fun displayMenu() {
        println("1. Создать")
        println("2. Просмотреть")
        println("3. Вернуться")
    }

    fun selectOption(): Int? {
        while(true) {
            println("Выберите пункт:")
            val choice = readLine()?.toIntOrNull()
            if (choice != null) {
                return choice
            } else {
                println("Нужно ввести число. Попробуйте снова.")
            }
        }}


    fun closeScanner() {
        scanner.close()
    }
}
