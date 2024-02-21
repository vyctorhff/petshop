package br.com.petshop.auth.exceptions;

import java.util.ArrayList;
import java.util.List;

public class PetshopAuthException extends Exception {

    private List<String> errors;

    public PetshopAuthException() {
        this.errors = new ArrayList<>();
    }

    public void add(String msg) {
        errors.add(msg);
    }
}
