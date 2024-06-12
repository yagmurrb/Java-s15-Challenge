package com.yagmur.model.person;

public  abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    //get ve set işlemleri ile encaplusation uygulamış olduk
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String whoYouAre();
}
