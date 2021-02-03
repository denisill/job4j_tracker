package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PointTest {

    @Test
    public void distance3dFirst() {
        Point point = new Point(0, 1, 5);
        Point point2 = new Point(1, 2, 3);
        double rsl = point.distance3d(point2);
        assertThat(rsl, closeTo(2.449, 0.001));
    }

    @Test
    public void distance3dSecond() {
        Point point = new Point(6, 4, 3);
        Point point2 = new Point(1, 0, 8);
        double rsl = point.distance3d(point2);
        assertThat(rsl, closeTo(8.124, 0.001));
    }
}