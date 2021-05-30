package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    List<T> getAll();

    Optional<T> getById(Long id);

    void create(Employee employee);

    int update(Employee employee);

    int delete(Long id);

}
