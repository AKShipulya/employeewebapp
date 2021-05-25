package com.mastery.java.task.dao;

import com.mastery.java.task.dao.mapper.EmployeeMapper;
import com.mastery.java.task.dto.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

import static com.mastery.java.task.dto.Gender.MALE;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeDaoTest {

    @InjectMocks
    private EmployeeDao employeeDao;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private EmployeeMapper employeeMapper;

    private static final Employee EMPLOYEE =
            new Employee(1L, "Test", "Employee", 1L, "TestTitle", MALE, new Date());


    @Test
    void createEmployee_success() {
        employeeDao.create(EMPLOYEE);

        verify(jdbcTemplate, times(1)).update(
                "INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth) VALUES(?,?,?,?,?,?)",
                EMPLOYEE.getFirstName(),
                EMPLOYEE.getLastName(),
                EMPLOYEE.getDepartmentId(),
                EMPLOYEE.getJobTile(),
                EMPLOYEE.getGender().toString(),
                EMPLOYEE.getDateOfBirth()
        );
    }

    @Test
    void getAllEmployees_success() {
        List<Employee> employees = singletonList(EMPLOYEE);

        when(jdbcTemplate.query("SELECT * FROM employee", employeeMapper)).thenReturn(employees);
        List<Employee> allEmployeeFromDao = employeeDao.getAll();
        Assert.assertEquals(employees, allEmployeeFromDao);
    }

    @Test
    void getEmployeeById_success() {
        when(jdbcTemplate.queryForObject("SELECT * FROM employee WHERE employee_id=?", employeeMapper, EMPLOYEE.getEmployeeId())).thenReturn(EMPLOYEE);
        Optional<Employee> employeeFromDao = employeeDao.getById(EMPLOYEE.getEmployeeId());
        Assert.assertEquals(Optional.of(EMPLOYEE), employeeFromDao);
    }

    @Test
    void updateEmployee_success() {
        employeeDao.update(EMPLOYEE, EMPLOYEE.getEmployeeId());

        verify(jdbcTemplate, times(1)).update(
                "UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=?, date_of_birth=? WHERE employee_id=?",
                EMPLOYEE.getFirstName(),
                EMPLOYEE.getLastName(),
                EMPLOYEE.getDepartmentId(),
                EMPLOYEE.getJobTile(),
                EMPLOYEE.getGender().toString(),
                EMPLOYEE.getDateOfBirth()
        );
    }

    @Test
    void deleteEmployee_success() {
        employeeDao.delete(EMPLOYEE.getEmployeeId());

        verify(jdbcTemplate, times(1)).update("DELETE FROM employee WHERE employee_id=?", EMPLOYEE.getEmployeeId());
    }
}
