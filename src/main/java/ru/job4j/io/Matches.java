package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (1 > matches || matches > 3) {
                System.out.println("Ошибка, спичек можно взять от 1 до 3\nОсталось " + count + " спичек");
                } else if (matches <= count) {
                    count -= matches;
                    System.out.println("Осталось " + count + " спичек");
                    turn = !turn;
                        } else {
                System.out.println("Ошибка, спичек меньше чем введенное число\nОсталось " + count + " спичек");
            }
        }
            if (!turn) {
                System.out.println("Выиграл первый игрок");
            } else {
                System.out.println("Выиграл второй игрок");
            }
    }
}