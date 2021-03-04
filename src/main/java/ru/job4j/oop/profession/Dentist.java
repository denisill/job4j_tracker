package ru.job4j.oop.profession;

public class Dentist extends Doctor {

    public Dentist(String name,
                   String surname,
                   String education,
                   int birthday,
                   String qualification,
                   boolean glasses) {
        super(name, surname, education, birthday, qualification, glasses);
    }

    public void fixTeeth() {
    }

    public void deleteTeeth() {
    }
}
