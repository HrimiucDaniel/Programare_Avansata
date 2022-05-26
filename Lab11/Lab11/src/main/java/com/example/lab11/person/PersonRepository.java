package com.example.lab11.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(value = "select * from person order by prieteni desc limit ?1", nativeQuery = true)
    public List<Person> getAllByPrieteniOrderByPrieteniDesc(int k);
}
