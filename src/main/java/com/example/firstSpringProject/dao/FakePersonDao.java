package com.example.firstSpringProject.dao;

import com.example.firstSpringProject.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Repository("fakedao")
public class FakePersonDao implements  PersonDao{
    private ArrayList db = new ArrayList<Person>();

    public int insertPerson(UUID id, Person p)
    {
        db.add(new Person(id , p.getName()));
        return 1;
    }

    @Override
    public List<Person> SelectAll() {
        return db;
    }
}
