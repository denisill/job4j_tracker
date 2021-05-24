package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        if (left.length() != right.length()) {
            return false;
        }
        for (Character character : left.toCharArray()) {
            if (!map.containsKey(character)) {
                map.put(character, 1);
            } else {
                map.put(character, map.get(character) + 1);
            }
        }
        for (Character character : right.toCharArray()) {
            if (!map.containsKey(character)) {
                return false;
            }
            if (map.get(character) == 1) {
                map.remove(character);
            } else {
                map.put(character, map.get(character) - 1);
            }
        }
        if (map.isEmpty()) {
            return true;
        }
        return false;
    }
}