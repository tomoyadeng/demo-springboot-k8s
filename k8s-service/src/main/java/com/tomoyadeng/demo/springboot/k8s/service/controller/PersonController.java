package com.tomoyadeng.demo.springboot.k8s.service.controller;

import com.tomoyadeng.demo.springboot.k8s.service.dao.PersonDao;
import com.tomoyadeng.demo.springboot.k8s.service.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;

    @GetMapping("")
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @PostMapping("")
    public Person add(@RequestBody Person person) {
        return personDao.add(person);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
                       @RequestBody Person person) {
        Assert.isTrue(id == person.getId(), "id not match");
        personDao.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        personDao.delete(id);
    }
}
