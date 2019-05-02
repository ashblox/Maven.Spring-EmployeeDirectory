package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService (EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee createEmployee(String firstName, String lastName, String title, String phoneNumber, String email, String hireDate, Long managerId, Long deptNumber) {
        Employee employee = new Employee(firstName, lastName, title, phoneNumber, email, hireDate, managerId, deptNumber);
        return employeeRepo.save(employee);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Iterable<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Iterable<Employee> findAllByManager(Long managerId) {
        return employeeRepo.findAllByManager(managerId);
    }

    public Employee findById(Long id) {
        return employeeRepo.getOne(id);
    }

    public Iterable<Employee> findAllWithNoManager() {
        return employeeRepo.findByManagerIsNull();
    }

    public List<Employee> findHierarchy(Long id) {
        List<Employee> managers = new ArrayList<>();
        Employee employee = findById(id);
        while (employee.getManager() != null) {
            Long managerId = employee.getManager();
            managers.add(findById(managerId));
            employee = findById(managerId);
        }
        return managers;
    }

//    public List<Employee> findEmployeesWithNoManager() {
//        List<Employee> employees = new ArrayList<>();
//        for (Employee e : findAll()) {
//            if (e.getManager() == null) {
//                employees.add(e);
//            }
//        }
//        return employees;
//    }

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

    public Employee updateManager(Long id, Long managerId) {
        Employee original = findById(id);
        original.setManager(managerId);
        return employeeRepo.save(original);
    }

    public boolean deleteEmployee(Long id) {
        employeeRepo.delete(id);
        return true;
    }
}
