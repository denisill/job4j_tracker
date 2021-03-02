package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortByIdDescItemTest {

    @Test
    public void compareDesc() {
        Item item1 = new Item();
        item1.setId(1);
        item1.setName("first Item");
        Item item2 = new Item();
        item2.setId(3);
        item2.setName("third Item");
        Item item3 = new Item();
        item3.setId(5);
        item3.setName("fifth Item");
        List<Item> items = Arrays.asList(item2, item1, item3);
        Comparator<Item> comparator = new SortByIdDescItem();
        Collections.sort(items, comparator);
        List<Item> expectedItems = Arrays.asList(item3, item2, item1);
        assertThat(items, is(expectedItems));
    }
}