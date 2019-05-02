package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController (DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Department>> findAll() {
        return new ResponseEntity<>(departmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/updateManager/{managerId}")
    public ResponseEntity<Department> updateManager(@PathVariable Long id, @PathVariable Long managerId) {
        return new ResponseEntity<>(departmentService.updateDeptManager(id, managerId), HttpStatus.OK);
    }

    @PutMapping("/{id}/changeName/{name}")
    public ResponseEntity<Department> updateName(@PathVariable Long id, @PathVariable String name) {
        return new ResponseEntity<>(departmentService.updateName(id, name), HttpStatus.OK);
    }
}
