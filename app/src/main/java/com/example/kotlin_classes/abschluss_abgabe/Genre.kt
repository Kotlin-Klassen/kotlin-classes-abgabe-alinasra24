enum class Genre(val description: String) {
    FICTION("Dragons and co"),
    NON_FICTION("Only reality"),
    SCIENCE("Physics, chemistry and co"),
    HISTORY("War and kings"),
    CHILDREN("Farytails");

    fun printDescription() {
        println( description)
    }
}
