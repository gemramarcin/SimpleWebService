package com.example.gtj.footballers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/footballers")
class FootballerController {

    @Autowired
    FootballerRepo footballerRepo;


    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public void addFootballer(@Valid @RequestBody Footballer footballer) {
        footballerRepo.save(footballer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateFootballer(@Valid @RequestBody Footballer footballer, @PathVariable long id) {
        footballerRepo.updateDetails(id, footballer.getAge(), footballer.getWeight(), footballer.getMarketValue());
    }

    @GetMapping("/{id}")
    public Footballer getFootballer(@PathVariable long id) throws Throwable {
        Footballer footballer = footballerRepo.findById(id).orElseThrow(() -> new FootballerNotFoundException(id));
        return footballer;
    }

    @GetMapping("/")
    public List<Footballer> getAll() {
        List<Footballer> footballers = new ArrayList<>();
        footballerRepo.findAll().forEach(footballers::add);
        return footballers;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeFootballer(@PathVariable long id) {
        footballerRepo.deleteById(id);
    }

}
