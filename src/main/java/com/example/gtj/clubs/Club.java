package com.example.gtj.clubs;

import com.example.gtj.footballers.Footballer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Component
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "community_seq_gen")
    @SequenceGenerator(
            name = "community_seq_gen",
            sequenceName = "community_seq",
            allocationSize = 1)
    @Column(name = "id" , nullable = false)
    private long id;
    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "budget" )
    private double budget;

    @JsonManagedReference
    @OneToMany(
            cascade = CascadeType.PERSIST,
            orphanRemoval = false
    )
    private List<Footballer> footballers;

    public void addFootballer(Footballer footballer) {
        footballers.add(footballer);
        footballer.setClub(this);
    }
}
