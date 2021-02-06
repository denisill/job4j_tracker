package ru.job4j.oop.pojo;

public class Library {
    public static void main(String[] args) {
        Book invisibleMan = new Book("The Invisible Man", 1250);
        Book dorianGray = new Book("The Picture of Dorian Gray", 900);
        Book cleanCode = new Book("Clean code", 864);
        Book frankenstein = new Book("Frankenstein", 1100);
        Book[] books = new Book[4];
        books[0] = invisibleMan;
        books[1] = dorianGray;
        books[2] = cleanCode;
        books[3] = frankenstein;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + ", " + books[i].getCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + ", " + books[i].getCount());
        }
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName() + ", " + books[i].getCount());
            }
        }
    }
}
