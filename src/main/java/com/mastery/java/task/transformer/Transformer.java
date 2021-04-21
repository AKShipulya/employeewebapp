package com.mastery.java.task.transformer;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.entity.Entity;

public class Transformer {

    Employee employee = new Employee();
    Entity entity = new Entity();

    public Entity fromEmployeeToEntity (Employee employee){
        entity.setEmployeeId(employee.getEmployeeId());
        entity.setFirstName(employee.getFirstName());
        entity.setLastName(employee.getLastName());
        entity.setDepartmentId(employee.getDepartmentId());
        entity.setJobTile(employee.getJobTile());
        entity.setGender(employee.getGender());
        entity.setDateOfBirth(employee.getDateOfBirth());
        return entity;
    }

}
