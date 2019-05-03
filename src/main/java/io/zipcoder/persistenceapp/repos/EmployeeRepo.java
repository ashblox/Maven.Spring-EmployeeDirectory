package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Iterable<Employee> findAllByDepartment(Department department);

    Iterable<Employee> removeAllByDepartment(Department department);
}
