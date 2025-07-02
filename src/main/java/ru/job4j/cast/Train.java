package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Передвигается по рельсам");
    }

    @Override
    public void mover() {
        System.out.println(getClass().getSimpleName() + " Движитель - Шкив");
    }
}
