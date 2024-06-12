package com.yagmur.model.person;

import com.yagmur.model.books.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books = new ArrayList<>();

    // Constructor
    //! constructor nedir araştır

    public Author(String name) {
        super(name);
    }

    // Getter for books
    public List<Book> getBooks() {
        return books;
    }

    // Setter for books
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Method to add a new book
    public void newBook(Book book) {
        books.add(book);
    }

    // Method to show books
    public void showBook() {
        for (Book book : books) {
            book.display();
        }
    }

    // Implementing the abstract method from Person class
    @Override
    public String whoYouAre() {
        StringBuilder info = new StringBuilder();
        info.append("Author Name: ").append(getName()).append("\n");
        info.append("Books:\n");
        for (Book book : books) {
            info.append(" - ").append(book.getTitle()).append("\n");
        }
        return info.toString();
    }
}

