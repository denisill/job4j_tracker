package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void collect() {
        List<Profile> profiles = List.of(
            new Profile(new Address("Moscow", "Lenina", 11, 17)),
            new Profile(new Address("Kazan", "Mira", 13, 345)),
            new Profile(new Address("London", "Central", 23, 130))
        );
        Profiles profs = new Profiles();
        List<Address> rsl = profs.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenina", 11, 17));
        expected.add(new Address("Kazan", "Mira", 13, 345));
        expected.add(new Address("London", "Central", 23, 130));
        assertThat(rsl, is(expected));
    }
}