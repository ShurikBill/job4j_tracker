package ru.job4j.tracker.oop;

import org.junit.jupiter.api.Test;
import ru.job4j.oop.Max;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxTest {

    @Test
    public void whenFirst3Second7Max7() {
        Max max = new Max();
        double result = max.maxMeaning(3.0, 7.0);
        assertThat(result).isEqualTo(7.0);
    }

    @Test
    public void whenFirst8Second2Max8() {
        Max max = new Max();
        double result = max.maxMeaning(8.0, 2.0);
        assertThat(result).isEqualTo(8.0);
    }

    @Test
    public void whenFirst10Second8Third4Max10() {
        Max max = new Max();
        double result = max.maxMeaning(10.0,8.0,4.0);
        assertThat(result).isEqualTo(10.0);
    }

    @Test
    public void whenFirst10Second8Third4Fourth12Max12() {
        Max max = new Max();
        double result = max.maxMeaning(10.0,8.0,4.0, 12.0);
        assertThat(result).isEqualTo(12.0);
    }

    @Test
    public void whenFirst11Second15Third12Fourth13Max15() {
        Max max = new Max();
        double result = max.maxMeaning(11.0,15.0,12.0, 13.0);
        assertThat(result).isEqualTo(15.0);
    }
}
