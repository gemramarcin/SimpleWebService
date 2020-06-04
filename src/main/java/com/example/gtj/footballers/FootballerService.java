package com.example.gtj.footballers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class FootballerService {

    private final FootballerRepo footballerRepo;


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
        footballerRepo.save(new Footballer("Cristiano", "Ronaldo", 35, 188.0, 80.0, 30000000.0));
        List<Footballer> footballers = new ArrayList<>();
        footballerRepo.findAll().forEach(footballers::add);
        return footballers;
    }

    void remove(long id) {
        footballerRepo.deleteById(id);
    }
}
