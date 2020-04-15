package com.example.gtj;

public class FootballerNotFoundException extends RuntimeException {

    public FootballerNotFoundException(long id){
        super("Footballer not found" + id);
    }
}
