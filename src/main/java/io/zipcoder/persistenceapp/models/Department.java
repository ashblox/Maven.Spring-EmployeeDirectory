package io.zipcoder.persistenceapp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Department {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long managerId;

    public Department() {
    }

    public Department(String deptName, Long managerId) {
        this.name = deptName;
        this.managerId = managerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return name;
    }

    public void setDeptName(String deptName) {
        this.name = deptName;
    }

    public Long getDeptManager() {
        return managerId;
    }

    public void setDeptManager(Long managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return name.equals(that.name) &&
                managerId.equals(that.managerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, managerId);
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + name + '\'' +
                ", manager=" + managerId +
                '}';
    }
}
