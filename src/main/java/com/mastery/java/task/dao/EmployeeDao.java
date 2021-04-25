package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dao.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements Dao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
    }

    public Employee getById(Long id) {
        return jdbcTemplate.query("SELECT * FROM employee WHERE employee_id=?", new EmployeeMapper(), id)
                .stream().findAny().orElse(null);
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

    public void update(Employee employee) {
        jdbcTemplate.update("UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=?, date_of_birth=? WHERE employee_id=?",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTile(),
                employee.getGender().toString(),
                employee.getDateOfBirth(),
                employee.getEmployeeId()
        );
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM employee WHERE employee_id=?", id);
    }

}
