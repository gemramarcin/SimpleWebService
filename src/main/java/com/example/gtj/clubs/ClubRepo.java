package com.example.gtj.clubs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepo extends JpaRepository<Club, Long> {
}
