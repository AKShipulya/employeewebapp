package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getAllEmployees(){
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
    }

    public Employee getEmployeeById(Long id){
        return jdbcTemplate.query("SELECT * FROM employee WHERE employee_id=?", new Object[]{id}, new EmployeeMapper())
                .stream().findAny().orElse(null);
    }

    public void saveEmployee(Employee employee){
        jdbcTemplate.update("INSERT INTO Employee VALUES(?,?,?,?,?,?)",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTile(),
                employee.getGender(),
                employee.getDateOfBirth()
        );
    }

    public void updateEmployee(Employee employee, Long id){
        jdbcTemplate.update("UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=?, date_of_birth=? WHERE employee_id=?",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTile(),
                employee.getGender(),
                employee.getDateOfBirth(), id
        );
    }

    public void deleteEmployee(Long id){
        jdbcTemplate.update("DELETE FROM employee WHERE employee_id=?", id);
    }

}
