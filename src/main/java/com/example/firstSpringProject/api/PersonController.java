package com.example.firstSpringProject.api;

import com.example.firstSpringProject.dao.RealDealDao;
import com.example.firstSpringProject.model.Person;
import com.example.firstSpringProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    @Autowired
    RealDealDao dao;

    @PostMapping
    public Person create(@RequestBody Person p){
        String name = p.getName();
        return dao.save(new Person(name));
    }
    @GetMapping
    List<Person> getAllPeople()
    {
        return dao.findAll() ;
    }

    @GetMapping("{id}")
    Optional<Person> getPersonById(@PathVariable("id") int id)
    {
        return dao.findById(id) ;
    }
    @PutMapping("{id}")
    Person updatePerson(@PathVariable("id") int id,@RequestBody Person p)
    {
        // ik i should be using a service but first time projects should be fun and i should pretend i dont know how to structure this
        Person existingPerson= dao.findById(id).orElseThrow( () -> new ArithmeticException());
        existingPerson.setName(p.getName());
        dao.save(existingPerson);
        return existingPerson ;
    }

    @DeleteMapping("{id}")
    List<Person> deletePerson(@PathVariable("id") int id)
    {
       dao.deleteById(id);
        return dao.findAll() ;
    }
}
