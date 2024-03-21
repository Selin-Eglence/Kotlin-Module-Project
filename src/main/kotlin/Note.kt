data class Note(val title: String,val content: String)


class NoteManager( private val menuHolder: MenuHolder<Note>) {

    fun noteMenu(archive: Archive) {
        while (true) {
            println("Меню заметок:")
            menuHolder.displayMenu()
            when (menuHolder.selectOption()) {
                1 -> createNote(archive)
                2 -> viewNotes(archive)
                3 -> return
                else -> println("Попробуйте снова.")
            }
        }
    }

    private fun createNote(archive: Archive) {
        val title = InputReader.readString("Введите заголовок заметки:")
        var content = ""
        while (content.isEmpty()) {
            content = InputReader.readString("Введите текст заметки:")
            if (content.isEmpty()) {
                println("Текст заметки не может быть пустым. Попробуйте снова.")
            }
        }
        val note = Note(title, content)
        archive.addNote(note)

    }



    private fun viewNotes(archive: Archive) {
        if (archive.notesList.isEmpty()) {
            println("Заметок пока нет.")
        } else {
            println("Список заметок:")
            archive.notesList.forEachIndexed { index, note ->
                println("${index + 1}. ${note.title}")}
            println("Для просмотра содержания следуйте следующим указаниям:")
            val choice= menuHolder.selectOption() ?: return
            if (choice in 1..archive.notesList.size) {
                val note1 = archive.notesList[choice-1]
                println(note1.content)
            }

        }}




}