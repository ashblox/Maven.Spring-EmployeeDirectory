package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService (DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department createDepartment(String deptName, Long deptManager) {
        Department department = new Department(deptName, deptManager);
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
        original.setDeptManager(managerId);
        return departmentRepo.save(original);
    }

    public boolean deleteDepartment(Long id) {
        departmentRepo.delete(id);
        return true;
    }

    public Department updateName(Long id, String name) {
        Department original = findById(id);
        original.setDeptName(name);
        return departmentRepo.save(original);
    }
}
