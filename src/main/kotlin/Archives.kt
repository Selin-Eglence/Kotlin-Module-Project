class Archive(val name: String, vararg notes: Note) {
    val notesList = mutableListOf<Note>()
    init {
        notesList.addAll(notes)
    }
    fun addNote(note: Note) {
        notesList.add(note)
    }

}
class ArchiveMenu(private val archives: MutableList<Archive>,
                  private val menuHolder: MenuHolder<Archive>,
                  private val noteManager: NoteManager) {

    fun run() {
        while (true) {
            println("Меню архивов:")
            menuHolder.displayMenu()
            when (menuHolder.selectOption()) {
                1 -> createArchive()
                2 -> viewArchives()
                3 -> return
                else -> println("Попробуйте снова.")
            }
        }
    }

    private fun createArchive() {
        val name = InputReader.readString("Введите название архива:")
        menuHolder.create(name, archives) { Archive(it) }
    }

    private fun viewArchives() {
        println("Список архивов:")
        archives.forEachIndexed { index, archive ->
            println("${index + 1}. ${archive.name}")
        }
        println("Выберите архив для открытия меню заметок:")
        val option= menuHolder.selectOption() ?: return
        if (option in 1..archives.size) {
            val selected = archives[option-1]
            noteManager.noteMenu(selected)
        }
        else {
            println("Выберите номер из списка")
        }


    }
}