package com.tomoyadeng.demo.springbootk8s.singledb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class K8sDbApplication {
    public static void main(String[] args) {
        SpringApplication.run(K8sDbApplication.class, args);
    }
}
