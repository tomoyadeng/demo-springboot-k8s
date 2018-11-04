package com.tomoyadeng.demo.springbootk8s.singledb.repository;

import com.tomoyadeng.demo.springbootk8s.singledb.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByLastName(String lastName);
}
