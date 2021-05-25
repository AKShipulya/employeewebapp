package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

    List<T> getAll();

    Optional<T> getById(Long id);

    void create(Employee employee);

    void update(Employee employee, Long id);

    void delete(Long id);

}
