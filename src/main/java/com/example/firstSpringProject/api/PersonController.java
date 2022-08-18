package com.example.firstSpringProject.api;

import com.example.firstSpringProject.model.Person;
import com.example.firstSpringProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService service)
    {
        this.personService=service;
    }

    @PostMapping
    void addPerson(@RequestBody Person person)
    {
        personService.insertPerson(person);
    }
    @GetMapping
    List<Person> getAllPeople()
    {
        return personService.getAllPeople();
    }

    void deletePerson(@PathVariable UUID id)
    {
        personService.deletePerson(id);
    }
    


}
