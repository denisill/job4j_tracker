package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, -5, 4, -4, -4, 0);
        List<Integer> positiveNumbers = numbers.stream().filter(number -> number >= 0).collect(Collectors.toList());
    }
}
