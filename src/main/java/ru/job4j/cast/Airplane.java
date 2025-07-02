package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Летает по воздуху");
    }

    @Override
    public void mover() {
        System.out.println(getClass().getSimpleName() + " Движитель - Турбина");
    }
}
