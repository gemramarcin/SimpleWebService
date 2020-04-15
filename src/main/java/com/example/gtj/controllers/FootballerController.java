package com.example.gtj.controllers;

import com.example.gtj.Footballer;
import com.example.gtj.FootballerNotFoundException;
import com.example.gtj.repositories.FootballerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/footballers")
class FootballerController {

    @Autowired
    FootballerRepo footballerRepo;

    @GetMapping("/{id}")
    public Footballer getFootballer(@PathVariable long id) throws Throwable {
        Footballer footballer = footballerRepo.findById(id).orElseThrow(() -> new FootballerNotFoundException(id));
        return footballer;
    }

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public void addFootballer(@Valid @RequestBody Footballer footballer) {
        footballerRepo.save(footballer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateFootballer(@Valid @RequestBody Footballer footballer, long id) {
        footballerRepo.updateDetails(footballer.getId(), footballer.getAge(), footballer.getWeight(), footballer.getMarketValue());
    }


    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeFootballer(@PathVariable long id) {
        footballerRepo.deleteById(id);
    }

}
