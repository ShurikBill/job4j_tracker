package ru.job4j.tracker.oop;

import org.junit.jupiter.api.Test;
import ru.job4j.oop.Point;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    public void whenDistance3DBetweenSamePointsThenZero() {
        Point a = new Point(1, 2, 3);
        Point b = new Point(1, 2, 3);
        double result = a.distance3d(b);
        double expected = 0.00;
        assertThat(result).isEqualTo(expected , withPrecision(0.01));
    }

    @Test
    public void whenDistance3DBetweenDifferentPointsThenCorrect() {
        Point a = new Point(1, 2, 3);
        Point b = new Point(4, 6, 8);
        double result = a.distance3d(b);
        double expected = 7.07; // sqrt(50)
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }
}
