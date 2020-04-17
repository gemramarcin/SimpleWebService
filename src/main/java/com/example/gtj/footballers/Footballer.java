package com.example.gtj.footballers;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
@Component
public class Footballer {

    private String firstName;
    private String lastName;
    private int age;
    private double height;
    private double weight;
    private double marketValue;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull private long id;


}
