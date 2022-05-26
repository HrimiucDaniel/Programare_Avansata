package com.example.lab11.person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    List<Person> getMostPopularPersons(int k);
    void addPerson(Person person);
    void updateName(int id, String nume);
    void deletePerson(int id);
}
