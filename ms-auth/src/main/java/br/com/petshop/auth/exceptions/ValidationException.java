package br.com.petshop.auth.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationException extends PetshopAuthException {

    private List<String> errors;

    public ValidationException() {
        this.errors = new ArrayList<>();
    }

    public void add(String msg) {
        errors.add(msg);
    }
}
