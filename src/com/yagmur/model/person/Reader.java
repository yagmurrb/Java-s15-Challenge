package com.yagmur.model.person;

import com.yagmur.model.books.Book;

import java.util.List;
import java.util.ArrayList;

public class Reader extends Person {
    public static final int BOOK_LIMIT = 5;
    private List<Book> borrowedBooks = new ArrayList<>(); // borrowedBooks listesini başlatıyoruz
    private List<Book> purchasedBooks = new ArrayList<>();

    public Reader(String name) {
        super(name);

    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() >= BOOK_LIMIT) {
            System.out.println("Cannot borrow more books. Book limit reached.");
        } else {
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void purchaseBook(Book book) {
        if (purchasedBooks.size() + borrowedBooks.size() >= BOOK_LIMIT) {
            System.out.println("Cannot purchase more books. Book limit reached.");
        } else {
            purchasedBooks.add(book);
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    // purchasedBooks getter metodu
    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }


    public void showBooks() {
        for (Book book : borrowedBooks) {
            book.display();
        }
    }

    @Override
    public String whoYouAre() {
        StringBuilder info = new StringBuilder();
        info.append("Reader Name: ").append(getName()).append("\n");
        info.append("Borrowed Books:\n");
        for (Book book : borrowedBooks) {
            info.append(" - ").append(book.getTitle()).append("\n");
        }
        info.append("Purchased Books:\n");
        for (Book book : purchasedBooks) {
            info.append(" - ").append(book.getTitle()).append("\n");
        }
        return info.toString();
    }

}
