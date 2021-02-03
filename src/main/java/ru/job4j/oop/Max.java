package ru.job4j.oop;

public class Max {
    public static int max(int first, int second) {
        boolean condition = first > second;
        int result = condition ? first : second;
        return result;
    }

    public static int max(int first, int second, int third) {
        boolean condition = first > max(second, third);
        int result = condition ? first : max(second, third);
        return result;
    }

    public static int max(int first, int second, int third, int fourth) {
        boolean condition = first > max(second, third, fourth);
        int result = condition ? first : max(second, third, fourth);
        return result;
    }
}
