import java.util.Scanner

class AllArchivesMenu {
    private val noteArchives: MutableMap<String, NoteArchive> = mutableMapOf()
    private val scanner: Scanner = Scanner(System.`in`)


    fun start() {
        val menu = Menu(scanner)
        menu.start("Список архивов:") { getOptions()}
    }

    private fun getOptions(): MutableList<MenuOption> {
        val options = mutableListOf<MenuOption>()

        options.add(MenuOption("Создать архив") { createArchive() })

        for (archiveName in noteArchives.keys) {
            options.add(MenuOption(archiveName) { openArchive(archiveName) })
        }

        return options
    }

    private fun createArchive() {
        while (true) {
            println("Введите название архива:")
            val archiveName: String = scanner.nextLine().trim()
            when {
                archiveName.isBlank() -> println("Имя архива не должно быть пустым")
                noteArchives.containsKey(archiveName) -> {
                    println("Архив с таким именем уже существует")
                    continue
                }

                else -> {
                    noteArchives[archiveName] = NoteArchive(archiveName)
                    break
                }
            }
        }
    }

    private fun openArchive(archiveName: String) {
        ArchiveMenu(noteArchives.getValue(archiveName), scanner).start()
    }
}