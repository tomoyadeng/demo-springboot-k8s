package com.tomoyadeng.demo.springboot.k8s.service.domain;

import lombok.Data;

@Data
public class Person {
    private long id;
    private String firstName;
    private String lastName;
}
