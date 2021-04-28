package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

import static com.mastery.java.task.dto.Gender.MALE;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class EmployeeDaoTest {

    @InjectMocks
    private EmployeeDao employeeDao;

    @Mock
    private JdbcTemplate jdbcTemplate;

    private final static Employee EMPLOYEE =
            new Employee(1L,"Test", "Employee", 1L, "TestTitle", MALE, new Date());

    @Test
    void createEmployee_success() {
        employeeDao.create(EMPLOYEE);

        verify(jdbcTemplate, times(1)).update(
                anyString(),
                eq(EMPLOYEE.getFirstName()),
                eq(EMPLOYEE.getLastName()),
                eq(EMPLOYEE.getDepartmentId()),
                eq(EMPLOYEE.getJobTile()),
                eq(EMPLOYEE.getGender().toString()),
                eq(EMPLOYEE.getDateOfBirth())
        );
    }

}
