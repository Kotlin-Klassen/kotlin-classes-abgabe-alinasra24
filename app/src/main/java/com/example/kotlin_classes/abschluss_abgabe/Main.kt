package com.example.kotlin_classes.abschluss_abgabe

import Book

fun main() {
    // Create a Library instance
    val library = Library()

    // Add a Library Address
    val address = Library.LibraryAddress("840 S 1300 E", "Salt Lake City", "10115")
    address.printAddress()

    // Add books to the library
    library.addBook(Book("1984", "George Orwell", Genre.FICTION))
    library.addBook(Book("A Brief History of Time", "Stephen Hawking", Genre.SCIENCE))
    library.addBook(Book("Harry Potter", "J.K. Rowling", Genre.CHILDREN))
    library.addBook(Book("The Selfish Gene", "Richard Dawkins", Genre.SCIENCE))


    // Display the current status of all books
    println("\nCurrent status of all books:")
    library.displayAllBooksStatus()

    // Create a Member
    val member = library.LibraryMember("Emily", "M001")

    // Borrow a book
    println("\nBorrow a book:")
    val bookToCheckout = library.searchBook("1984").firstOrNull()
    if (bookToCheckout != null) {
        member.checkoutBook(bookToCheckout, "2024-12-31")
    } else {
        println("Book '1984' was not found.")
    }

    // Reserve another book
    println("\nReserve a book:")
    val bookToReserve = library.searchBook("A Brief History of Time").firstOrNull()
    if (bookToReserve != null) {
        member.reserveBook(bookToReserve)
    } else {
        println("A Brief History of Time' was not found.")
    }

    // Display the updated status of all books
    println("\nUpdated status of all books:")
    library.displayAllBooksStatus()
}
