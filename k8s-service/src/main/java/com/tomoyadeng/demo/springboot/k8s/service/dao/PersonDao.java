package com.tomoyadeng.demo.springboot.k8s.service.dao;

import com.tomoyadeng.demo.springboot.k8s.service.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonDao implements AbstractDao<Person> {
    @Value("${app.singledb.host}")
    private String dbServiceHost;

    @Value("${app.singledb.port}")
    private String dbServicePort;

    private String url;

    @PostConstruct
    private void init() {
        url = "http://" + dbServiceHost + ":" + dbServicePort + "/person";
    }

    @Autowired private RestTemplate restTemplate;

    @Override
    public List<Person> findAll() {
        Person[] rsp =
                Optional.ofNullable(restTemplate.getForEntity(url, Person[].class).getBody())
                        .orElse(new Person[0]);
        return Arrays.asList(rsp);
    }

    @Override
    public Person add(Person person) {
        return restTemplate.postForEntity(url, person, Person.class).getBody();
    }

    @Override
    public void update(Person person) {
        restTemplate.put(url + "/" + person.getId(), person);
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete(url + "/" + id);
    }
}
