package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenAscByName() {
        Comparator<Job> cmp = new JobIncrByName();
        int result = cmp.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 2)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenAscByPriority() {
        Comparator<Job> cmp = new JobIncrByPriority();
        int result = cmp.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 3)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> cmp = new JobDescByName();
        int result = cmp.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 2)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> cmp = new JobDescByPriority();
        int result = cmp.compare(
                new Job("Fix bug", 5),
                new Job("Fix bug", 2)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenDescByNameAndDescByPriority() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriority());
        int result = cmp.compare(
                new Job("X task", 0),
                new Job("Fix bug", 4)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenAscByNameAndAscByPriority() {
        Comparator<Job> cmp = new JobIncrByName().thenComparing(new JobIncrByPriority());
        int result = cmp.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 3)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}