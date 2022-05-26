package com.example.lab11.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> getMostPopularPersons(int k) {
        return personRepository.getAllByPrieteniOrderByPrieteniDesc(k);
    }

    @Override
    public void addPerson(Person person) {
        Optional<Person> foundPerson = personRepository.findById(person.getId());
        if(foundPerson.isEmpty()){
            personRepository.save(person);
        }
    }

    @Override
    public void updateName(int id, String nume) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if(foundPerson.isPresent()){
            foundPerson.get().setNume(nume);
            personRepository.save(foundPerson.get());
        }
    }

    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
}
