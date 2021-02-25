package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListTest {
    @Test
    public void whenTwoList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
        in.add(new int[] {5, 3, 8});
        List<Integer> expect = Arrays.asList(1, 2, 3, 5, 3, 8);
        assertThat(ConvertList.convert(in), is(expect));
    }
}