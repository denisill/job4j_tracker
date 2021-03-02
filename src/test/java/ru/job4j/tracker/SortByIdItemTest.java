package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SortByIdItemTest {

    @Test
    public void compare() {
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
        Comparator<Item> comparator = new SortByIdItem();
        Collections.sort(items, comparator);
        List<Item> expectedItems = Arrays.asList(item1, item2, item3);
        assertThat(items, is(expectedItems));
    }
}