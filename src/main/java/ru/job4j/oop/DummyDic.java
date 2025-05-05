package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String voice = eng;
        return voice;
    }

    public static void main(String[] args) {
        DummyDic tell = new DummyDic();
        String say = tell.engToRus("eng");
        System.out.println("Неизвестное слово. " + say);
    }
}
