package com.yagmur.model.librarian;
import com.yagmur.model.books.Book;
import com.yagmur.model.library.Library;
import com.yagmur.model.person.Reader;

public class Librarian {
    private String name;
    private String password;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void searchBook(Library library, String bookName) {
        boolean found = false;
        for (Book book : library.getBooks()) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void verifyMember(Library library, Reader reader) {
        if (library.getReaders().contains(reader)) {
            System.out.println("Member verified.");
        } else {
            System.out.println("Member not found.");
        }
    }

    public void issueBook(Library library, Book book, Reader reader) {
        library.lendBook(book, reader);
    }

    public void returnBook(Library library, Book book, Reader reader) {
        library.takeBackBook(book, reader);
    }

    public void calculateFine(Reader reader) {
        // Fine calculation logic
    }

    public void createBill(Reader reader) {
        // Bill creation logic
    }
}
