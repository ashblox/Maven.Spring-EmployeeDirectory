package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Iterable<Employee> findAllByEmployee(Employee manager);

    Iterable<Employee> findByEmployeeIsNull();
}
