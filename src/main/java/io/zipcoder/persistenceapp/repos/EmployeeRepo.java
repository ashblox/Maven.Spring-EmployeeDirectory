package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Iterable<Employee> findAllByManager(Employee manager);

    Iterable<Employee> findAllByDepartment(Long departmentId);

    Iterable<Employee> findByManagerIsNull();

    @Transactional
    Long removeAllByDepartment(Long deptId);
}
