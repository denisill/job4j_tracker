package ru.job4j.oop;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MaxTest {

    @Test
    public void whenMax5() {
        int result = Max.max(2, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenMax7() {
        int result = Max.max(4, 2 , 7);
        assertThat(result, is(7));
    }

    @Test
    public void whenMax8() {
        int result = Max.max(2, 5, 3, 8);
        assertThat(result, is(8));
    }
}