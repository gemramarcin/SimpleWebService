package com.example.gtj.clubs;

import com.example.gtj.footballers.Footballer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double budget;

    @JsonManagedReference
    @OneToMany(
            cascade = CascadeType.PERSIST
    )
    private List<Footballer> footballers;

    void addFootballer(Footballer footballer) {
        footballers.add(footballer);
        footballer.setClub(this);
    }
}
