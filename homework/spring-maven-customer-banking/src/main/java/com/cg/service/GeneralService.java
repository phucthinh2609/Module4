package com.cg.service;

import com.cg.model.Customer;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T getById(Long id);

    T save(T t);

    void remove(Long id);
}

