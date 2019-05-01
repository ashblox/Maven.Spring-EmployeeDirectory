package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee createEmployee(String firstName, String lastName, String title, String phoneNumber, String email, Date hireDate, Employee manager, int deptNumber) {
        Employee employee = new Employee(firstName, lastName, title, phoneNumber, email, hireDate, manager, deptNumber);
        return employeeRepo.save(employee);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Iterable<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepo.getOne(id);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee original = findById(id);
        original.setFirstName(employee.getFirstName());
        original.setLastName(employee.getLastName());
        original.setTitle(employee.getTitle());
        original.setPhoneNumber(employee.getPhoneNumber());
        original.setEmail(employee.getEmail());
        original.setHireDate(employee.getHireDate());
        original.setManager(employee.getManager());
        original.setDeptNumber(employee.getDeptNumber());
        return employeeRepo.save(original);
    }

    public boolean deleteEmployee(Long id) {
        employeeRepo.delete(id);
        return true;
    }
}
