package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 1;
        if (left.length() != right.length()) {
            return false;
        }
        for (Character character : left.toCharArray()) {
            if (!map.containsKey(character)) {
                map.put(character, count);
            } else {
                map.put(character, count + 1);
            }
        }
        for (Character character : right.toCharArray()) {
            if (!map.containsKey(character)) {
                return false;
            } else {
                map.put(character, map.get(character) - 1);
            }
        }
        for (Character character : map.keySet()) {
            if (map.get(character) != 0) {
                return false;
            }
        }
        return true;
    }
}
