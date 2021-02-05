package ru.job4j.oop.profession;

public class Programmer extends Engineer {
    private int age;

    public Programmer(String name, String surname, String education, int birthday, String degree, int age) {
        super(name, surname, education, birthday, degree);
        this.age = age;
    }

    public void writeCode() {
    }

    public void writeTest() {
    }
}
