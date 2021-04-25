package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface Controller<T> {

    List<T> getAll();

    T getByID(Long id);

    void create(Employee employee);

    void update(Employee employee);

    void delete(Long id);

}
