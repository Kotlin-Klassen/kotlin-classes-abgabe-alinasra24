package com.example.kotlin_classes.abschluss_abgabe

import Book
import BookStatus

/**
 * Represents a library with a collection of books and functionality for managing them.
 */
class Library {

    // List of books in the library
    private val books = mutableListOf<Book>()

    /**
     * Nested class representing the address of the library.
     *
     * @param street the street address of the library
     * @param city the city where the library is located
     * @param zipCode the postal code of the library
     */
    class LibraryAddress(private val street: String, private val city: String, private val zipCode: String) {
        /**
         * Prints the address of the library.
         */
        fun printAddress() {
            println("Address: $street, $city, $zipCode")
        }
    }

    /**
     * Method Searches for books in the library by title or author.
     *
     * @param query the search query, either part of the title or the author's name
     * @return a list of books matching the query
     */
    fun searchBook(query: String): List<Book> {
        return books.filter {
            it.title.contains(query, ignoreCase = true) || it.author.contains(query, ignoreCase = true) }
    }

    /**
     * Method Displays the current status of all books in the library.
     */
    fun displayAllBooksStatus() {
        if (books.isEmpty()) {
            println("No books in the library.")
        } else {
            books.forEach { book ->
                // Verwende die getReadableStatus-Methode der BookStatus-Klasse
                val statusDescription = book.status.getReadableStatus()
                println("Title: ${book.title}, Genre: ${book.genre} (${book.genre.description}, Author: ${book.author}, Status: $statusDescription")
            }
        }
    }

    /**
     * Adds a new book to the library.
     *
     * @param book the book to add to the library
     */
    fun addBook(book: Book) {
        books.add(book)
        println("Book '${book.title}' with Genre '${book.genre}:${book.genre.description}' by ${book.author} was added to the library.")
    }

    /**
     * Inner class representing a member of the library.
     *
     * @param name the name of the member
     * @param memberId the unique identifier for the member
     */
    inner class LibraryMember(val name: String, val memberId: String) {

        /**
         * Checks out a book from the library for a member.
         *
         * @param book the book to be checked out
         * @param dueDate the date when the book should be returned
         */
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println(book.status.getReadableStatus()+" from Member with ID: "+ memberId)
            } else {
                println("Book '${book.title}' is not available for checkout. Current status: ${book.status}.")
            }
        }

        /**
         * Reserves a book for a member.
         *
         * @param book the book to be reserved
         */
        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println(book.status.getReadableStatus()+" with ID: "+ memberId)
            } else {
                println("Book '${book.title}' is not available for reservation. Current status: ${book.status}.")
            }
        }
    }

}