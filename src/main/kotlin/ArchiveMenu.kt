import java.util.Scanner

class ArchiveMenu (
    private val archive: NoteArchive,
    private val scanner: Scanner
) {


    fun start() {
        val menu = Menu(scanner)

        menu.start("Список заметок в архиве ${archive.name}:") {getOptions()}
    }

    private fun createNote() {
        while (true) {
            println("Введите название заметки:")
            val noteName = scanner.nextLine().trim()

            when {
                noteName.isBlank() -> {
                    println("Имя заметки не должно быть пустым")
                    continue
                }
                archive.noteMap.containsKey(noteName) -> {
                    println("Заметка с таким именем уже существует")
                    continue
                }
            }

            println("Введите текст заметки:")
            val noteText = scanner.nextLine().trim()

            if (noteText.isBlank()) {
                println("Текст заметки не должен быть пустым")
                continue
            }

            archive.noteMap[noteName] = Note(noteName, noteText)
            break
        }
    }

    private fun getOptions(): MutableList<MenuOption> {
        val options = mutableListOf<MenuOption>()
        options.add(MenuOption("Создать заметку") { createNote() })

        for (noteName: String in archive.noteMap.keys) {
            options.add(MenuOption(noteName) { openNote(noteName) })
        }

        return options
    }

    private fun openNote(noteName: String) {
        NoteMenu(archive.noteMap.getValue(noteName), scanner).start()
    }
}
