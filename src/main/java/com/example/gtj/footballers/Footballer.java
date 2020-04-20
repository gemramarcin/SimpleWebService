package com.example.gtj.footballers;

import com.example.gtj.clubs.Club;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

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

    @JsonBackReference
    @OneToOne
    private Club club;




}
