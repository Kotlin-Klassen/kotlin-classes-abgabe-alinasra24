sealed class BookStatus {

    object Available : BookStatus()

    data class CheckedOut(val dueDate: String) : BookStatus()

    data class Reserved(val reservedBy: String) : BookStatus()

    fun getReadableStatus(): String {
        return when (this) {
            is Available -> "Das Buch ist verfügbar."
            is CheckedOut -> "Das Buch ist ausgeliehen, Rückgabedatum: $dueDate."
            is Reserved -> "Das Buch ist reserviert von $reservedBy"
            else -> "Unbekannter Status."
        }
    }
}



