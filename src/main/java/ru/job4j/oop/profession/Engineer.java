package ru.job4j.oop.profession;

public class Engineer extends Profession {
    private String degree;

    public Engineer(String name, String surname, String education, int birthday, String degree) {
        super(name, surname, education, birthday);
        this.degree = degree;
    }

    public void createProject() {
    }

    public void control() {
    }
}
