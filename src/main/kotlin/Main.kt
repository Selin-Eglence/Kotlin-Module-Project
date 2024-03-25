fun main() {
    val app = ArchiveApp()
    app.run()
}

class ArchiveApp {
    private val archives = mutableListOf<Archive>()
    private val menuHolderNote = MenuHolder<Note>()
    private val menuHolderArchive = MenuHolder<Archive>()
    private val noteManager = NoteManager(menuHolderNote)
    private val archiveMenu = ArchiveMenu(archives, menuHolderArchive, noteManager)



    fun run() {
        while (true) {
            menuHolderNote.displayMainMenu()
            when (menuHolderNote.selectOption()) {
                1 -> archiveMenu.run()
                2-> {
                    menuHolderNote.closeScanner()
                    return
                }
                else -> println("Некорректный выбор. Попробуйте снова.")
            }
        }
    }


}