package com.example.gtj.footballers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/footballers")
class FootballerController {

    private FootballerService footballerService;


    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void addFootballer(@Valid @RequestBody Footballer footballer) {
        footballerService.save(footballer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateFootballer(@Valid @RequestBody Footballer footballer, @PathVariable long id) {
        footballerService.updateDetails(id, footballer);
    }

    @GetMapping("/{id}")
    public Footballer getFootballer(@PathVariable long id) {
        return footballerService.getFootballer(id);
    }

    @GetMapping
    public List<Footballer> getAll() {
        return footballerService.getAll();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeFootballer(@PathVariable long id) {
        footballerService.remove(id);
    }

}
