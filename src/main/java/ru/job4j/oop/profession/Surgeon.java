package ru.job4j.oop.profession;

public class Surgeon extends Doctor {

    public Surgeon (String name, String surname, String education, int birthday, String qualification, boolean glasses) {
        super(name, surname, education, birthday, qualification, glasses);
    }

    public void makeOperation() {
    }
}
