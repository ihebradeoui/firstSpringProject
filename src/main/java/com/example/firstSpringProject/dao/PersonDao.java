package com.example.firstSpringProject.dao;

import com.example.firstSpringProject.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson( UUID id, Person p);
    default int insertPerson(Person p){
        UUID id = UUID.randomUUID();
        return insertPerson(id , p);
    }

    List<Person> SelectAll();

    Optional<Person> selectPersonById(UUID id );
    int deletePerson(UUID id);

    int updatePerson(UUID id, Person person);
}
