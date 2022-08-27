package com.example.firstSpringProject.service;

import com.example.firstSpringProject.dao.PersonDao;
import com.example.firstSpringProject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private PersonDao dao ;
    @Autowired
    public PersonService (@Qualifier("fakedao") PersonDao dao)
    {
        this.dao= dao;
    }

    public int insertPerson(Person p){
        return dao.insertPerson(p);
    }

    public List<Person> getAllPeople()
    {
        return dao.SelectAll();
    }

    public int updatePerson(int id, Person person)
    {
        return  dao.updatePerson(id,person);
    }
    public int deletePerson(int id)
    {
        return  dao.deletePerson(id);
    }

    public Optional<Person> GetPerson(int id)
    {
        return dao.selectPersonById(id);
    }
}
