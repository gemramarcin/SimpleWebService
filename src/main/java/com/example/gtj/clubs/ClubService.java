package com.example.gtj.clubs;

import com.example.gtj.footballers.Footballer;
import com.example.gtj.footballers.FootballerNotFoundException;
import com.example.gtj.footballers.FootballerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
class ClubService {

    private ClubRepo clubRepo;
    private FootballerRepo footballerRepo;


    void updateClub(Club club, long id) {
        Club newClub = clubRepo.findById(id).orElseThrow(() -> new ClubNotFoundException(id));

        newClub.setBudget(club.getBudget());
        newClub.setName(club.getName());

        clubRepo.saveAndFlush(newClub);
    }

    Club getClubById(long id) {
        return clubRepo.findById(id).orElseThrow(() -> new ClubNotFoundException(id));
    }

    void save(Club club) {
        clubRepo.save(club);
    }

    List<Club> getAll() {
        return new ArrayList<>(clubRepo.findAll());
    }

    void deleteById(long id) {
        clubRepo.deleteById(id);
    }

    List<Footballer> getAllFootballersByClubId(long clubId) {
        return clubRepo.findById(clubId).orElseThrow(() -> new ClubNotFoundException(clubId)).getFootballers();
    }

    void addFootballer(long id, long footballerId) {
        clubRepo.findById(id).
                orElseThrow(() -> new ClubNotFoundException(id)).
                addFootballer(footballerRepo.findById(footballerId).
                        orElseThrow(() -> new FootballerNotFoundException(footballerId)));
        clubRepo.flush();
    }
}
