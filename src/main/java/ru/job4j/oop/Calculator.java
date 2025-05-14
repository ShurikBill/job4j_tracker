package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int a) {
        return x - a;
    }

    public int multiply(int b) {
        return x * b;
    }

    public int divide(int c) {
        return x / c;
    }

    public int sumAllOperation(int a, int b, int c, int y) {
        return sum(y) + minus(a) + multiply(b) + divide(c);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);

        int result1 = Calculator.minus(4);
        System.out.println(result1);

        Calculator calculator1 = new Calculator();
        int result2 = calculator1.multiply(5);
        System.out.println(result2);

        Calculator calculator2 = new Calculator();
        int result3 = calculator2.divide(5);
        System.out.println(result3);

        Calculator calculator3 = new Calculator();
        int result4 = calculator3.sumAllOperation(4, 5, 5, 10);
        System.out.println(result4);
    }
}