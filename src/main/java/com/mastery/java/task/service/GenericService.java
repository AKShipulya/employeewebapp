package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface GenericService<T> {

    List<T> getAll();

    T getById(Long id);

    void create(Employee employee);

    void update(Employee employee);

    void delete(Long id);

}
