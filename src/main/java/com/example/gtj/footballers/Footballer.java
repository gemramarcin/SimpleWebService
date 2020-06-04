package com.example.gtj.footballers;

import com.example.gtj.clubs.Club;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Footballer {


    private String firstName;
    private String lastName;
    private int age;
    private double height;
    private double weight;
    private double marketValue;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private long id;

    @JsonBackReference
    @OneToOne
    private Club club;


    public Footballer(String firstName, String lastName, int i, double v, double v1, double v2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = i;
        this.height = v;
        this.weight = v1;
        this.marketValue = v2;

    }
}
