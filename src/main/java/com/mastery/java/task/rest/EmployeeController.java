package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();

    }

    @GetMapping("/{id}")
    public Employee getEmployeeByID(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/createEmployee")
    public void saveEmployee(Employee employee){
        employeeService.saveEmployee(employee);
    }

    @GetMapping("/updateEmployee/{id}")
    public void updateEmployee(Employee employee,@PathVariable Long id){
        employeeService.updateEmployee(employee, id);
    }

    @GetMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }


}
