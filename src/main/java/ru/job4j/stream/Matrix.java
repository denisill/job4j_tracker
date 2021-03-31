package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public List<Integer> converter(Integer[][] array) {
        return Stream.of(array).flatMap(Stream::of).collect(Collectors.toList());
    }
}