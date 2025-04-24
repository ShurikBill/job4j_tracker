package ru.job4j.tracker.checkstyle;

public class Broken {
    private int sizeOfEmpty = 10;
    public String surName;
    public String name;
    public static final String NEW_VALUE = "";

    public Broken() {
    }

    public void echo() {
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    void method(int a) {
    }
}