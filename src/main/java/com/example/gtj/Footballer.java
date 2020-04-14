package com.example.gtj;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Builder

@Entity
public class Footballer {

    private String firstName;
    private String lastName;
    private int age;
    private float height;
    private float weight;
    private double marketValue;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}
