package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Двигается по скоростным трассам");
    }

    @Override
    public void mover() {
        System.out.println(getClass().getSimpleName() + " Движитель - Колесо");
    }
}
