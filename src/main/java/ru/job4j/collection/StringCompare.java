package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minLenght = Math.min(left.length(), right.length());
        for (int i = 0; i < minLenght; i++) {
            int cmpr = Character.compare(left.charAt(i), right.charAt(i));
            if (cmpr != 0) {
                return cmpr;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}