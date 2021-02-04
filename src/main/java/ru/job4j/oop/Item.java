package ru.job4j.oop;

public class Item {
    private String name;
    private int id;

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Item item = new Item();
    }
}
