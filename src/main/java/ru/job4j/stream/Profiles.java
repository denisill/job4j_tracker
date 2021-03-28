package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .sorted(Comparator.comparing(a -> a.getAddress().getCity()))
                .map(profile -> profile.getAddress())
                .distinct()
                .collect(Collectors.toList());
    }
}
