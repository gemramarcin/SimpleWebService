package com.example.gtj.footballers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
class FootballerService {

    private FootballerRepo footballerRepo;


    void save(Footballer footballer) {
        footballerRepo.save(footballer);
    }

    void updateDetails(long id, Footballer footballer) {
        footballerRepo.updateDetails(id, footballer.getAge(), footballer.getWeight(), footballer.getMarketValue());
    }

    Footballer getFootballer(long id) {
        return footballerRepo.findById(id).orElseThrow(() -> new FootballerNotFoundException(id));
    }

    List<Footballer> getAll() {
        List<Footballer> footballers = new ArrayList<>();
        footballerRepo.findAll().forEach(footballers::add);
        return footballers;
    }

    void remove(long id) {
        footballerRepo.deleteById(id);
    }
}
