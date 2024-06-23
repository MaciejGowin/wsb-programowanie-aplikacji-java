package com.coderbrother.javaprogramming.security.model;

import lombok.Builder;
import lombok.Getter;

import javax.security.auth.Subject;
import java.security.Principal;

@Getter
@Builder
public class BasicPrincipal implements Principal {

    private final String userId;

    @Override
    public String getName() {
        return userId;
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }
}
