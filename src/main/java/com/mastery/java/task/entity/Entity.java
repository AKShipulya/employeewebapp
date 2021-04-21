package com.mastery.java.task.entity;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;

import java.util.Date;
import java.util.Objects;

public class Entity {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private Long departmentId;
    private String jobTile;
    private Gender gender;
    private Date dateOfBirth;

    public Entity(Long employeeId, String firstName, String lastName, Long departmentId, String jobTile, Gender gender, Date dateOfBirth) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTile = jobTile;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Entity(String firstName, String lastName, Long departmentId, String jobTile, Gender gender, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTile = jobTile;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Entity(){

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobTile() {
        return jobTile;
    }

    public void setJobTile(String jobTile) {
        this.jobTile = jobTile;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(employeeId, entity.employeeId) &&
                Objects.equals(firstName, entity.firstName) &&
                Objects.equals(lastName, entity.lastName) &&
                Objects.equals(departmentId, entity.departmentId) &&
                Objects.equals(jobTile, entity.jobTile) &&
                gender == entity.gender &&
                Objects.equals(dateOfBirth, entity.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, departmentId, jobTile, gender, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", departmentId=" + departmentId +
                ", jobTile='" + jobTile + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

}
