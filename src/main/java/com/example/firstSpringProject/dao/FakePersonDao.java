package com.example.firstSpringProject.dao;

import com.example.firstSpringProject.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fakedao")
public class FakePersonDao implements  PersonDao{
    private ArrayList<Person> db = new ArrayList<Person>();

    public int insertPerson(int id, Person p)
    {
        db.add(new Person(id , p.getName()));
        return 1;
    }

    @Override
    public List<Person> SelectAll() {
        return db;
    }

    @Override
    public Optional<Person> selectPersonById(int id) {
        return db.stream().filter(person -> person.getId() == id)
                            .findFirst();
    }

    @Override
    public int deletePerson(int id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()) {
            return 0;
        }
        db.remove(personMaybe);
        return 1;
    }

    @Override
    public int updatePerson(int id, Person person) {
        if(deletePerson(id) == 1)
        {
            db.add(person);
            return 1;
        }
        return 0;
    }
}
