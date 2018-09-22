package com.tomoyadeng.demo.springboot.k8s.service.dao;

import java.util.List;

public interface AbstractDao<T> {
    List<T> findAll();

    T add(T t);

    void update(T t);

    void delete(Long id);
}
