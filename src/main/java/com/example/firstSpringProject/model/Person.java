package com.example.firstSpringProject.model;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
@Entity
public class Person
{
    @Id
    private  int id;
    private  String name;

    public Person() {    }
    public Person(@JsonProperty("id") int id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Person(
                  @JsonProperty("name") String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
    {this.name=name;}
}
