package com.example.firstSpringProject.dao;

import com.example.firstSpringProject.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RealDealDao extends JpaRepository<Person,Integer> {
    List<Person> findByNameContainingOrNameContaining(String text, String textAgain);

}
