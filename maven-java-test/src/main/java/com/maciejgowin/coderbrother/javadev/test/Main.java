package com.maciejgowin.coderbrother.javadev.test;

import static java.util.Optional.ofNullable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static String upperCase(String value) {
        return ofNullable(value).map(String::toUpperCase).orElse(null);
    }
}