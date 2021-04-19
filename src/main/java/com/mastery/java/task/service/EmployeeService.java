package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployeeById(Long id){
        return employeeDao.getEmployeeById(id);
    }

    public void saveEmployee(Employee employee){
        employeeDao.saveEmployee(employee);
    }

    public void updateEmployee(Employee employee, Long id){
        employeeDao.updateEmployee(employee, id);
    }

    public void deleteEmployee(Long id){
        employeeDao.deleteEmployee(id);
    }

}
