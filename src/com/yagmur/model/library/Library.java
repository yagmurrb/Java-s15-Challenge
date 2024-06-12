package com.yagmur.model.library;

import com.yagmur.model.books.Book;
import com.yagmur.model.person.Reader;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Library {
    private final Set<Long> bookIds; // Kitap kimliklerini tutacak Set veri yapısı
    private List<Book> books;
    private List<Reader> readers;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.bookIds = new HashSet<>(); // Set veri yapısını başlatıyoruz
    }

    // Getter for books
    public List<Book> getBooks() {
        return books;
    }

    // Setter for books
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Getter for readers
    public List<Reader> getReaders() {
        return readers;
    }

    // Setter for readers
    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    // Method to add a book
    public void addBook(Book book) {
        if (!bookIds.contains(book.getBookId())) { // Kitap ID'si zaten var mı kontrol ediyoruz
            books.add(book);
            bookIds.add(book.getBookId()); // Kitap ID'sini Set'e ekliyoruz
        } else {
            System.out.println("Bu kimlik numarasına sahip bir kitap zaten var.");
        }
    }

    // Method to add a reader
    public void addReader(Reader reader) {
        readers.add(reader);
    }

    // Method to lend a book
    public void lendBook(Book book, Reader reader) {
        if (reader.getBorrowedBooks().size() < Reader.BOOK_LIMIT) {
            reader.borrowBook(book);
            System.out.println("Book " + book.getName() + " lent to " + reader.getName());
        } else {
            System.out.println("Cannot lend book. Book limit reached for " + reader.getName());
        }
    }

    // Method to take back a book
    public void takeBackBook(Book book, Reader reader) {
        reader.returnBook(book);
    }

    public Book findBookById(Long bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null; // Kitap bulunamazsa null döndürür
    }

    // Kitabı ID'ye göre silme metodu
    public boolean deleteBookById(Long bookId) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookId().equals(bookId)) {
                iterator.remove();
                return true; // Kitap bulundu ve silindi
            }
        }
        return false; // Kitap bulunamadı
    }

    // Method to show all books
    public void showBooks() {
        for (Book book : books) {
            book.display();
        }
    }

    public void displayBooksByCategory(Class<? extends Book> category) {
        for (Book book : books) {
            if (category.isInstance(book)) {
                book.display();
            }
        }
    }
}
