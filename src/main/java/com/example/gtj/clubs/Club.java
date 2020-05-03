package com.example.gtj.clubs;

import com.example.gtj.footballers.Footballer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Component
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "budget")
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
