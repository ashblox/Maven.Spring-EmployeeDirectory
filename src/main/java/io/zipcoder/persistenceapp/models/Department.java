package io.zipcoder.persistenceapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Department {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int deptNumber;
    private String deptName;
    private Employee deptManager;

    public Department() {
    }

    public Department(String deptName, Employee deptManager) {
        this.deptName = deptName;
        this.deptManager = deptManager;
    }

    public int getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(int deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Employee getDeptManager() {
        return deptManager;
    }

    public void setDeptManager(Employee deptManager) {
        this.deptManager = deptManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return deptName.equals(that.deptName) &&
                deptManager.equals(that.deptManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptName, deptManager);
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", deptManager=" + deptManager +
                '}';
    }
}
