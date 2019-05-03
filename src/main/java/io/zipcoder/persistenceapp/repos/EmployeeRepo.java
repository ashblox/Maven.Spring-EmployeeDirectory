package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Iterable<Employee> findAllByManager(Long managerId);

    Iterable<Employee> findAllByDepartment(Long departmentId);

    Iterable<Employee> findByManagerIsNull();

//    boolean deleteByDepartment(Long deptId);
}
