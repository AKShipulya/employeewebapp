package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface GenericController<T> {

    List<T> getAll();

    T getById(Long id);

    void create(Employee employee);

    void update(Employee employee);

    void delete(Long id);

}
