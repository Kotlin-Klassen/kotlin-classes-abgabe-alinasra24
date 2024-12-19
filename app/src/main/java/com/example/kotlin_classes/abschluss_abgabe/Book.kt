data class Book(
    var title: String,
    var author: String,
    var genre: Genre,
    var status: BookStatus = BookStatus.Available
)