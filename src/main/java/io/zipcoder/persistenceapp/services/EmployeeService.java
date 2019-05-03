package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.DepartmentRepo;
import io.zipcoder.persistenceapp.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;
    private DepartmentRepo departmentRepo;

    @Autowired
    public EmployeeService (EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    public Employee createEmployee(String firstName, String lastName, String title, String phoneNumber, String email, String hireDate, Department department) {
        Employee employee = new Employee(firstName, lastName, title, phoneNumber, email, hireDate, department);
        return employeeRepo.save(employee);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Iterable<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Iterable<Employee> findAllByManager(Long managerId) {
        List<Employee> employees = new ArrayList<>();
        for (Employee e : findAll()) {
            if (e.getDepartment().getManager().getId() == managerId) {
                employees.add(e);
            }
        }
        return employees;
    }

    public Iterable<Employee> findAllByDepartment(Long deptId) {
        return employeeRepo.findAllByDepartment(departmentRepo.getOne(deptId));
    }

    public Employee findById(Long id) {
        return employeeRepo.getOne(id);
    }

    public Iterable<Employee> findAllWithNoManager() {
        return findAllByManager(null);
    }

    public List<Employee> findHierarchy(Long id) {
        List<Employee> managers = new ArrayList<>();
        Employee employee = findById(id);
        while (employee.getDepartment().getManager() != null) {
            Employee manager = employee.getDepartment().getManager();
            managers.add(manager);
            employee = manager;
        }
        return managers;
    }

    public List<Employee> findAllByManagerIncIndirect(Long managerId) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : findAll()) {
            if (findHierarchy(employee.getId()).contains(findById(managerId))) {
                employees.add(employee);
            }
        }
        return employees;
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee original = findById(id);
        original.setFirstName(employee.getFirstName());
        original.setLastName(employee.getLastName());
        original.setTitle(employee.getTitle());
        original.setPhoneNumber(employee.getPhoneNumber());
        original.setEmail(employee.getEmail());
        original.setHireDate(employee.getHireDate());
        original.setDepartment(employee.getDepartment());
        return employeeRepo.save(original);
    }

    public Employee updateDepartment(Long id, Long deptId) {
        Employee original = findById(id);
        original.setDepartment(departmentRepo.getOne(deptId));
        return employeeRepo.save(original);
    }

    public boolean deleteEmployee(Long id) {
        employeeRepo.delete(id);
        return true;
    }

    public boolean deleteEmployeeList(List<Employee> employees) {
        for (Employee e : employees) {
            employeeRepo.delete(e.getId());
        }
        return true;
    }

    public Iterable<Employee> removeAllByDepartment(Long deptId) {
        return employeeRepo.removeAllByDepartment(departmentRepo.getOne(deptId));
    }

}
