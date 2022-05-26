package com.example.lab11.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping(value = "/most-popular")
    public List<Person> getMostPopularPersons(@RequestParam(value = "k") int k){
        return personService.getMostPopularPersons(k);
    }

    @PostMapping
    void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @PutMapping
    void updateName(@RequestParam(value = "id") int id, @RequestParam(value = "nume") String nume){
        personService.updateName(id, nume);
    }

    @DeleteMapping
    void deletePerson(@RequestParam(value = "id") int id){
        personService.deletePerson(id);
    }
}
