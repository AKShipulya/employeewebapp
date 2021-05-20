package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dao.GenericDao;
import com.mastery.java.task.dao.mapper.EmployeeMapper;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exception.EmployeeNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements GenericService<Employee> {

    private final GenericDao<Employee> employeeDao;

    public EmployeeService(GenericDao<Employee> employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    public Optional<Employee> getById(Long id) {
        if(employeeDao.getById(id).isPresent()){
            return employeeDao.getById(id);
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    public void create(Employee employee) {
        employeeDao.create(employee);
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    public void delete(Long id) {
        if (employeeDao.delete(id) == 0){
            throw new EmployeeNotFoundException("Employee not found");
        }else
        employeeDao.delete(id);
    }

}
