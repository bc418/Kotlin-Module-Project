import java.util.Scanner

class Menu (
    private val scanner: Scanner
) {
    companion object {
        const val DIVIDER = "============================================================================="
    }

    fun start(header: String, getOptions: () -> List<MenuOption>) {

        while (true) {
            val options = getOptions()

            println(DIVIDER)
            println(header)
            println("0. Выход")


            for (i in 0 until options.size) {
                println("${i + 1}. ${options[i].name}")
            }

            println("\nВведите команду:")

            val command = scanner.nextLine().trim().toIntOrNull()

            when {
                command == null -> println("Команда должна быть числом")
                command == 0 -> break
                command in 1..options.size -> options[command - 1].lambda()
                else -> println("Такой команды не существует")
            }
        }
    }
}