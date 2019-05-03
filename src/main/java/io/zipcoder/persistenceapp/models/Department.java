package io.zipcoder.persistenceapp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Department {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Employee manager;

    public Department() {
    }

    public Department(String deptName, Employee manager) {
        this.name = deptName;
        this.manager = manager;
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

    public Employee getDeptManager() {
        return manager;
    }

    public void setDeptManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return name.equals(that.name) &&
                manager.equals(that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manager);
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + name + '\'' +
                ", manager=" + manager.getFirstName() + " " + manager.getLastName()+
                '}';
    }
}
