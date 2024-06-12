package com.yagmur.model.books;

import com.yagmur.model.person.Author;

import java.util.Date;

public class Journals extends Book {
    private String journalType;

    public Journals(Long bookId, Author author, String name, double price, String status, String edition, Date dateOfPurchase, String journalType) {
        super(bookId, author, name, price, status, edition, dateOfPurchase);
        this.journalType = journalType;
    }

    public String getJournalType() {
        return journalType;
    }

    public void setJournalType(String journalType) {
        this.journalType = journalType;
    }
    @Override
    public void display() {
        super.display(); // Üst sınıfın display metodunu çağır
        System.out.println("Journal Type: " + journalType);
    }
}