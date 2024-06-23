package com.coderbrother.javaprogramming.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
