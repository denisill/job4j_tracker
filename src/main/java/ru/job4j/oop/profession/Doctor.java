package ru.job4j.oop.profession;

public class Doctor extends Profession {
    private String qualification;
    private boolean glasses;

    public Doctor(String name, String surname, String education, int birthday, String qualification, boolean glasses) {
        super(name, surname, education, birthday);
        this.qualification = qualification;
        this.glasses = glasses;
    }

    public void giveRecommendation() {
    }

    public void heal() {
    }
}
