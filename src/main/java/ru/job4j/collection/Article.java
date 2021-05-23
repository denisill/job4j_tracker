package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] originArr = origin.split("[ ,!;:\\.]+");
        String[] lineArr = line.split("[ ,!;:\\.]+");
        Set<String> setOrigin = new HashSet<>(Arrays.asList(originArr));
        Set<String> setLine = new HashSet<>(Arrays.asList(lineArr));
        if (setOrigin.containsAll(setLine)) {
            return true;
        }
        return false;
    }
}