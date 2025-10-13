package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemComparatorTest {

    @Test
    public void whenSortAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Charlie"));
        items.add(new Item("Alice"));
        items.add(new Item("Bob"));

        Collections.sort(items, new ItemAscByName());

        assertThat(items)
                .extracting(Item::getName)
                .containsExactly("Alice", "Bob", "Charlie");
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Charlie"));
        items.add(new Item("Alice"));
        items.add(new Item("Bob"));

        Collections.sort(items, new ItemDescByName());

        assertThat(items)
                .extracting(Item::getName)
                .containsExactly("Charlie", "Bob", "Alice");
    }
}