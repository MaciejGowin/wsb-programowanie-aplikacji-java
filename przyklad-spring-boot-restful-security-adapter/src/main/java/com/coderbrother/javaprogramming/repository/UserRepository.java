package com.coderbrother.javaprogramming.repository;

import com.coderbrother.javaprogramming.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Fake repository, to be taken from DB
@Repository
public class UserRepository {

    private static final List<User> users = List.of(
            User.builder()
                    .id("1")
                    .email("test1@coderbrother.com")
                    .password("test1")
                    .firstName("First1")
                    .lastName("Last1")
                    .build(),
            User.builder()
                    .id("2")
                    .email("test2@coderbrother.com")
                    .password("test2")
                    .firstName("First2")
                    .lastName("Last2")
                    .build()
    );

    public Optional<User> getUserById(final String id) {
        return users.stream()
                .filter(user -> Objects.equals(id, user.getId()))
                .findFirst();
    }

    public Optional<User> getUserByEmail(final String email) {
        return users.stream()
                .filter(user -> Objects.equals(email, user.getEmail()))
                .findFirst();
    }
}
