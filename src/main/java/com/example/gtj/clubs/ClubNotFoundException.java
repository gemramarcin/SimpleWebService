package com.example.gtj.clubs;

class ClubNotFoundException extends RuntimeException {

   ClubNotFoundException(long id) {
        super("Club not found" + id);
    }
}
