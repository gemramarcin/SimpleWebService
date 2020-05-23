package com.example.gtj.clubs;

import com.example.gtj.footballers.Footballer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clubs")
class ClubController {

    private final ClubService clubService;


    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void addClub(@Valid @RequestBody Club club) {
        clubService.save(club);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateClub(@Valid @RequestBody Club club, @PathVariable long id) {
        clubService.updateClub(club, id);
    }

    @GetMapping("/{id}")
    public Club getClub(@PathVariable long id) throws Throwable {
        return clubService.getClubById(id);
    }

    @GetMapping
    public List<Club> getAll() {
        return clubService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeClub(@PathVariable long id) {
        clubService.deleteById(id);
    }


    @GetMapping("/{clubId}/footballers")
    public List<Footballer> getAllFootballersByClubId(@PathVariable long clubId) {
        return clubService.getAllFootballersByClubId(clubId);
    }

    @PutMapping("/{id}/footballers/{footballerId}")
    public void addFootballerToClub(@PathVariable long id, @PathVariable long footballerId) {
        clubService.addFootballer(id, footballerId);
    }
}
