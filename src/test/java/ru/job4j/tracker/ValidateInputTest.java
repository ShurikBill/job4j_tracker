package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.Mock;
import ru.job4j.tracker.input.Validate;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateTest {

    @Test
    void whenInvalid() {
        Output output = new Stub();
        Input in = new Mock(
                new String[] {"one", "1"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValid3Correct() {
        Output output = new Stub();
        Input in = new Mock(
                new String[] {"2", "3", "1"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        Validate input1 = new Validate(output, in);
        int selected1 = input1.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(3);
        Validate input2 = new Validate(output, in);
        int selected2 = input2.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(1);
    }

    @Test
    void whenValidNegative() {
        Output output = new Stub();
        Input in = new Mock(
                new String[] {"-8"}
        );
        Validate input = new Validate(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-8);
    }
}