package ru.job4j.action;

import ru.job4j.input.Input;
import ru.job4j.Tracker;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}