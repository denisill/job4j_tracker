package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String originTxt = origin.replaceAll("\\p{P}", "");
        String[] originArr = originTxt.split(" ");
        String lineTxt = line.replaceAll("\\p{P}", "");
        String[] lineArr = lineTxt.split(" ");
        Set<String> setOrigin = new HashSet<>(Arrays.asList(originArr));
        for (String str : lineArr) {
            if (!setOrigin.contains(str)) {
                return false;
            }
        }
        return true;
    }
}