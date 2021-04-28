package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Deprecated
    private final Date DATE = new Date(90, Calendar.JANUARY,1);
    private final Employee EMPLOYEE = new Employee("Test", "Employee", 1L, "TestTitle", Gender.MALE, DATE);

    @MockBean //was @Autowired
    private EmployeeService employeeService;

//    @MockBean
//    private EmployeeDao employeeDao;

    @Test
    public void create(){
        employeeService.create(EMPLOYEE);
        Assert.assertEquals("Test", EMPLOYEE.getFirstName());
        Assert.assertEquals("Employee", EMPLOYEE.getLastName());
    }

}
