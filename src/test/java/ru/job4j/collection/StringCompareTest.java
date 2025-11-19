package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftIsPrefixOfRightThenNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivan", "Ivanov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenRightIsPrefixOfLeftThenPositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanova", "Ivan"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenBothStringsAreEmptyThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "", ""
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftIsEmptyAndRightIsNotEmptyThenNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "", "A"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftIsNotEmptyAndRightIsEmptyThenPositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "A", ""
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenDifferentCaseThenUsesUnicodeOrder() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Apple", "apple"
        );
        assertThat(result).isLessThan(0);
    }
}