package com.tomoyadeng.demo.springboot.k8s.db.controller;

import com.tomoyadeng.demo.springboot.k8s.db.domain.Person;
import com.tomoyadeng.demo.springboot.k8s.db.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("")
    public @ResponseBody List<Person> findAll() {
        List<Person> results = new ArrayList<>();
        personRepository.findAll().forEach(results::add);
        return results;
    }

    @PostMapping("")
    public @ResponseBody Person add(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public @ResponseBody Person update(@PathVariable("id") Long id,
            @RequestBody Person person) {
        Assert.isTrue(id == person.getId(), "id not match");
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        personRepository.deleteById(id);
    }
}
