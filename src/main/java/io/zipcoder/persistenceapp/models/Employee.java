package io.zipcoder.persistenceapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private String phoneNumber;
    private String email;
    private String hireDate;
    private Long manager;
    private Long deptNumber;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String title, String phoneNumber, String email, String hireDate, Long manager, Long deptNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hireDate = hireDate;
        this.manager = manager;
        this.deptNumber = deptNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long managerId) {
        this.manager = managerId;
    }

    public Long getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(Long deptNumber) {
        this.deptNumber = deptNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return deptNumber == employee.deptNumber &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                title.equals(employee.title) &&
                Objects.equals(phoneNumber, employee.phoneNumber) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(hireDate, employee.hireDate) &&
                Objects.equals(employee, employee.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, title, phoneNumber, email, hireDate, manager, deptNumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
