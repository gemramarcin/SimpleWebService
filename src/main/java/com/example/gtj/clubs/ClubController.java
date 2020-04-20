package com.example.gtj.clubs;

import com.example.gtj.footballers.Footballer;
import com.example.gtj.footballers.FootballerNotFoundException;
import com.example.gtj.footballers.FootballerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clubs")
class ClubController {

    @Autowired
    ClubRepo clubRepo;

    @Autowired
    FootballerRepo footballerRepo;

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public void addClub(@Valid @RequestBody Club club) {
        clubRepo.save(club);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateClub(@Valid @RequestBody Club club, @PathVariable long id) {

        Club newClub = clubRepo.findById(id).orElseThrow(() -> new ClubNotFoundException(id));

        newClub.setBudget(club.getBudget());
        newClub.setName(club.getName());

        clubRepo.saveAndFlush(club);
    }

    @GetMapping("/{id}")
    public Club getClub(@PathVariable long id) throws Throwable {
        Club club = clubRepo.findById(id).orElseThrow(() -> new ClubNotFoundException(id));
        return club;
    }

    @GetMapping("/")
    public List<Club> getAll() {
        List<Club> clubs = new ArrayList<>();
        clubRepo.findAll().forEach(clubs::add);
        return clubs;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeClub(@PathVariable long id) {
        clubRepo.deleteById(id);
    }


    @GetMapping("/{id}/footballers")
    public List<Footballer> getAllFootballersByCLubId(@PathVariable long id) {
        return clubRepo.findById(id).orElseThrow(() -> new ClubNotFoundException(id)).getFootballers();
    }

    @PutMapping("/{id}/footballers/{footballerId}")
    public void addFootballerToClub(@PathVariable long id, @PathVariable long footballerId) {
        clubRepo.findById(id).
                orElseThrow(() -> new ClubNotFoundException(id)).
                addFootballer(footballerRepo.findById(footballerId).
                        orElseThrow(() -> new FootballerNotFoundException(footballerId)));
        clubRepo.flush();

    }
}
