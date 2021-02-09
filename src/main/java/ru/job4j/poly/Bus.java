package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("the bus is going");
    }

    @Override
    public void passengers(int passenger) {
        System.out.println("Количество пассажиров: " + passenger);
    }

    @Override
    public int fill(int fuel) {
        int price = fuel * 50;
        return price;
    }
}
