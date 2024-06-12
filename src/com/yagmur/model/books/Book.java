package com.yagmur.model.books;

import com.yagmur.model.person.Author;

import java.util.Date;

public class Book {
    private Long bookId;
    private String author;
    private String name;
    private double price;
    private String status;
    private String edition;
    private Date dateOfPurchase;

    // Constructor
    public Book(Long bookId, Author author, String name, double price, String status, String edition, Date dateOfPurchase) {
        this.bookId = bookId;
        this.author = String.valueOf(author);
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    // Getter for bookId
    public Long getBookId() {
        return bookId;
    }

    // Setter for bookId
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for status
    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for edition
    public String getEdition() {
        return edition;
    }

    // Setter for edition
    public void setEdition(String edition) {
        this.edition = edition;
    }

    // Getter for dateOfPurchase
    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    // Setter for dateOfPurchase
    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    // Method to display book details
    public void display() {
        System.out.println("Book ID: " + bookId + ", Author: " + author + ", Name: " + name + ", Price: " + price + ", Status: " + status + ", Edition: " + edition + ", Date of Purchase: " + dateOfPurchase);
    }

    // Method to get title
    public String getTitle() {
        return name;
    }

    // Method to change owner
    public void changeOwner(String newOwner) {
        this.author = newOwner;
    }

    // Method to get owner
    public String getOwner() {
        return author;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    // Kitabın durumunu güncelleme metodu
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // Kitabın baskı sayısını güncelleme metodu
    public void updateEdition(String newEdition) {
        this.edition = newEdition;
    }
}

