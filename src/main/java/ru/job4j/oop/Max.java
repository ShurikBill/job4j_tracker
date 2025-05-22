package ru.job4j.oop;

public class Max {
    public double maxMeaning (double first, double second) {
        return first > second ? first : second;
    }

    public double maxMeaning (double first, double second, double third) {
        return maxMeaning(
                first,
                maxMeaning(second, third)
        );
    }

    public double maxMeaning (double first, double second, double third, double fourth) {
        return maxMeaning(
                maxMeaning(first, second),
                maxMeaning(third, fourth)
        );
    }
}
