package br.com.petshop.auth.model;

import java.util.Arrays;
import java.util.List;

public enum Roles {
    ADMIN("admin"),
    USER("user"),
    EMPLOYEE("employee");

    private final String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> toStringList() {
        return Arrays.stream(Roles.values())
            .map(value -> value.getName())
            .toList();
    }
}
