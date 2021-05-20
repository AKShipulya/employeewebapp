package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface GenericController<T> {

    List<T> getAll();

    Optional<T> getById(Long id);

    void create(Employee employee);

    void update(Employee employee);

    void delete(Long id);

}
