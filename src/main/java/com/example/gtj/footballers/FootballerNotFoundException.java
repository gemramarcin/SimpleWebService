package com.example.gtj.footballers;

public class FootballerNotFoundException extends RuntimeException {

    public FootballerNotFoundException(long id) {
        super("Footballer not found" + id);
    }

}
