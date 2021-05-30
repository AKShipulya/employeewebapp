package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;

import com.mastery.java.task.service.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements GenericController<Employee> {

    private final GenericService<Employee> employeeService;

    public EmployeeController(GenericService<Employee> employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Employee employee, @PathVariable Long id) {
        employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }


}
