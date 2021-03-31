package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void converterMatrix() {
        Integer[][] array = {{1, 3}, {4, 6}};
        List<Integer> expected = List.of(1, 3, 4, 6);
        Matrix matrix = new Matrix();
        List<Integer> rsl = matrix.converter(array);
        assertThat(rsl, is(expected));
    }
}