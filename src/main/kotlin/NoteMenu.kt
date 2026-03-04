import java.util.Scanner


class NoteMenu (
    private val note: Note,
    private val scanner: Scanner
) {
    fun start() {
        val menu = Menu(scanner)
        menu.start("Текст заметки ${note.name}:\n${note.text}") {emptyList()}
    }

}