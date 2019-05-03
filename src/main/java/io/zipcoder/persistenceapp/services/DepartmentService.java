package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.DepartmentRepo;
import io.zipcoder.persistenceapp.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepo departmentRepo;
    private EmployeeRepo employeeRepo;

    @Autowired
    public DepartmentService (DepartmentRepo departmentRepo, EmployeeRepo employeeRepo) {
        this.departmentRepo = departmentRepo;
        this.employeeRepo = employeeRepo;
    }

    public Department createDepartment(String deptName, Employee manager) {
        Department department = new Department(deptName, manager);
        return departmentRepo.save(department);
    }

    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public Iterable<Department> findAll() {
        return departmentRepo.findAll();
    }

    public Department findById(Long id) {
        return departmentRepo.getOne(id);
    }

    public Department updateDeptManager(Long id, Long managerId) {
        Department original = findById(id);
        original.setManager(employeeRepo.getOne(managerId));
        return departmentRepo.save(original);
    }

    public boolean deleteDepartment(Long id) {
        departmentRepo.delete(id);
        return true;
    }

    public Department updateName(Long id, String name) {
        Department original = findById(id);
        original.setName(name);
        return departmentRepo.save(original);
    }
}
