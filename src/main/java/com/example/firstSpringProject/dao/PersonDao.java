package com.example.firstSpringProject.dao;

import com.example.firstSpringProject.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public interface PersonDao {
    Random rand = new Random();

    int insertPerson( int id, Person p);
    default int insertPerson(Person p){
        int id = rand.nextInt();
        return insertPerson(id , p);
    }

    List<Person> SelectAll();

    Optional<Person> selectPersonById(int id );
    int deletePerson(int id);

    int updatePerson(int id, Person person);
}
