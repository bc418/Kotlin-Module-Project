data class NoteArchive (
    val name: String,
    val noteMap: MutableMap<String, Note> = mutableMapOf()
)