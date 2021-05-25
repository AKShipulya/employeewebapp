package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dao.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao implements GenericDao<Employee> {

    private final JdbcTemplate jdbcTemplate;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate, EmployeeMapper employeeMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeMapper = employeeMapper;
    }

    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM employee", employeeMapper);
    }

    public Optional<Employee> getById(Long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM employee WHERE employee_id=?", employeeMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public void create(Employee employee) {
        jdbcTemplate.update("INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth) VALUES(?,?,?,?,?,?)",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTile(),
                employee.getGender().toString(),
                employee.getDateOfBirth()
        );
    }

    public void update(Employee employee, Long id) {
        jdbcTemplate.update("UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=?, date_of_birth=? WHERE employee_id=?",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTile(),
                employee.getGender().toString(),
                employee.getDateOfBirth()
        );
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM employee WHERE employee_id=?", id);
    }

}
