package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void collectAddress() {
        List<Profile> profiles = List.of(
            new Profile(new Address("Amsterdam", "Lenina", 11, 17)),
            new Profile(new Address("Moscow", "Mira", 13, 345))
        );
        Profiles profs = new Profiles();
        List<Address> rsl = profs.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Amsterdam", "Lenina", 11, 17));
        expected.add(new Address("Moscow", "Mira", 13, 345));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenDistinctAddress() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Amsterdam", "Lenina", 11, 17)),
                new Profile(new Address("Moscow", "Mira", 13, 345)),
                new Profile(new Address("Bari", "Street", 74, 123)),
                new Profile(new Address("Amsterdam", "Lenina", 11, 17))
        );
        Profiles profs = new Profiles();
        List<Address> rsl = profs.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Amsterdam", "Lenina", 11, 17));
        expected.add(new Address("Bari", "Street", 74, 123));
        expected.add(new Address("Moscow", "Mira", 13, 345));
        assertThat(rsl, is(expected));
    }
}