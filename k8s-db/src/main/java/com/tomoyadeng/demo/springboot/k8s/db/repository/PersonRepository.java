package com.tomoyadeng.demo.springboot.k8s.db.repository;

import com.tomoyadeng.demo.springboot.k8s.db.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByLastName(String lastName);
}
