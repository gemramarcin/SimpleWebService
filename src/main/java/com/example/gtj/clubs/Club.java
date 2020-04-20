package com.example.gtj.clubs;

import com.example.gtj.footballers.Footballer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter


@Entity
@Component
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private double budget;

    @JsonManagedReference
    @OneToMany(
            cascade = CascadeType.PERSIST,
            orphanRemoval = false
    )
    private List<Footballer> footballers = new ArrayList<>();

    public void addFootballer(Footballer footballer){
        footballers.add(footballer);
        footballer.setClub(this);
    }
}
