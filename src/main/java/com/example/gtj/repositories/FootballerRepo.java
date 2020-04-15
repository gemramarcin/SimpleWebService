package com.example.gtj.repositories;

import com.example.gtj.Footballer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballerRepo extends CrudRepository<Footballer, Long> {
    @Modifying
    @Query("UPDATE Footballer f SET f.age = :age, f.height = :height f.weight = :weight f.marketValue = :marketValue WHERE f.id = :footballerId")
    int updateDetails(@Param("footballerId") long footballerId, @Param("age") int age,  @Param("weight") double weight,
                      @Param("marketValue") double marketValue);



}
