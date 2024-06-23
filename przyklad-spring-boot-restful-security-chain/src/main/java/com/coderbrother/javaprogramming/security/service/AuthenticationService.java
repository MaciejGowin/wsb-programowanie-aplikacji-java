package com.coderbrother.javaprogramming.security.service;

import com.coderbrother.javaprogramming.repository.UserRepository;
import com.coderbrother.javaprogramming.security.model.BasicPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    public Optional<BasicPrincipal> authenticate(final String email, final String password) {
        // We should not store plain password
        return userRepository.getUserByEmail(email)
                .filter(user -> Objects.equals(password, user.getPassword()))
                .map(user -> BasicPrincipal.builder().userId(user.getId()).build());
    }
}
