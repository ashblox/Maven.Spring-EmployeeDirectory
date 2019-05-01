package io.zipcoder.persistenceapp.repos;

import io.zipcoder.persistenceapp.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
