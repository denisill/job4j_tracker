package ru.job4j.ooa;

public class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;
    private int countEngine;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountEngine() {
        return countEngine;
    }

    public void setCountEngine() {
        this.countEngine = countEngine;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine(int countEngine) {
        if (this.name != "A320") {
            countEngine = 4;
            System.out.println("Количество двигателей равно: " + countEngine);
        } else {
            System.out.println("Количество двигателей равно: " + COUNT_ENGINE);
        }
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
