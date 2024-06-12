package com.yagmur.model.books;

import com.yagmur.model.person.Author;

import java.util.Date;

public class Study_Books extends Book {
    private String subject;

    public Study_Books(Long bookId, Author author, String name, double price, String status, String edition, Date dateOfPurchase, String subject) {
        super(bookId, author, name, price, status, edition, dateOfPurchase);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Override
    public void display() {
        super.display(); // Üst sınıfın display metodunu çağır
        System.out.println("Subject: " + subject);
    }
}
