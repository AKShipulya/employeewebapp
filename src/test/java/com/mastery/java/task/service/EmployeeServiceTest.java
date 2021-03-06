package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    private final Date DATE = new Date();
    private final Employee EMPLOYEE = new Employee(1L, "Test", "Employee", 1L, "TestTitle", Gender.MALE, DATE);

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeDao employeeDao;

    @Test
    public void createEmployee_success() {
        employeeService.create(EMPLOYEE);
        verify(employeeDao, times(1)).create(EMPLOYEE);
        Assert.assertEquals("Test", EMPLOYEE.getFirstName());
    }

    @Test
    public void getAllEmployees_success() {
        List<Employee> employeesFromDao = Arrays.asList(EMPLOYEE);
        when(employeeDao.getAll()).thenReturn(employeesFromDao);
        List<Employee> employeeList = employeeService.getAll();
        verify(employeeDao, times(1)).getAll();
        Assert.assertEquals(employeesFromDao, employeeList);
    }

    @Test
    public void getEmployeeById_success() {
        when(employeeDao.getById(EMPLOYEE.getEmployeeId())).thenReturn(Optional.of(EMPLOYEE));
        Optional<Employee> employee = employeeService.getById(EMPLOYEE.getEmployeeId());
        Assert.assertEquals(Optional.of(EMPLOYEE), employee);
    }

    @Test
    public void updateEmployee_success() {
        when(employeeDao.update(EMPLOYEE)).thenReturn(1);
        employeeService.update(EMPLOYEE);
        verify(employeeDao, times(1)).update(EMPLOYEE);
    }

    @Test
    public void deleteEmployee_success() {
        when(employeeDao.delete(EMPLOYEE.getEmployeeId())).thenReturn(1);
        employeeService.delete(EMPLOYEE.getEmployeeId());
        verify(employeeDao, times(1)).delete(EMPLOYEE.getEmployeeId());
    }

}