package com.mastery.java.task.service;

import com.mastery.java.task.dao.GenericDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements GenericService<Employee> {

    private final GenericDao<Employee> employeeDao;

    public EmployeeService(GenericDao<Employee> employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    public Employee getById(Long id) {
        return employeeDao.getById(id);
    }

    public void create(Employee employee) {
        employeeDao.create(employee);
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    public void delete(Long id) {
        employeeDao.delete(id);
    }

}
