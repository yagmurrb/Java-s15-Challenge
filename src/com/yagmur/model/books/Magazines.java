package com.yagmur.model.books;

import com.yagmur.model.person.Author;

import java.util.Date;

public class Magazines extends Book {
    private String magazineType;

    public Magazines(Long bookId, Author author, String name, double price, String status, String edition, Date dateOfPurchase, String magazineType) {
        super(bookId, author, name, price, status, edition, dateOfPurchase);
        this.magazineType = magazineType;
    }

    public String getMagazineType() {
        return magazineType;
    }

    public void setMagazineType(String magazineType) {
        this.magazineType = magazineType;
    }
    @Override
    public void display() {
        super.display(); // Üst sınıfın display metodunu çağır
        System.out.println("Magazine Type: " + magazineType);
    }
}