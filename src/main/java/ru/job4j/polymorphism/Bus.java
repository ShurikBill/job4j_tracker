package ru.job4j.polymorphism;

public class Bus implements Transport{
    @Override
    public void move() {
        System.out.println("Автобус едет по заданному маршруту");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Автобус вмещает " + count + " пассажира(-ов)");
    }

    @Override
    public int refuel(int fuel) {
        int result = fuel * 65;
        System.out.println("Цена топлива - " + result + " рублей");
        return result;
    }


    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.move();
        bus.passengers(35);
        bus.refuel(100);
    }
}
