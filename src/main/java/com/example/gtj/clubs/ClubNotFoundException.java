package com.example.gtj.clubs;

class ClubNotFoundException extends RuntimeException {

    public ClubNotFoundException(long id) {
        super("Club not found" + id);
    }
}
