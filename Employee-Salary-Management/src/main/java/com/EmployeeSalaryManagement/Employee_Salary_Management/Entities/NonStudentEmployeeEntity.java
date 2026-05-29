package com.EmployeeSalaryManagement.Employee_Salary_Management.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NonStudentEmployeeEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    private String fullName;
    private int age;
    private String contractType;
    private double baseSalary;
    private double bonusAmount;
    private double netSalary;
    private Long peselNumber;
    private String department;
    private double workedHours;

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public Long getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(Long peselNumber) {
        this.peselNumber = peselNumber;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContractType() {
        return contractType;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public int getAge() {
        return age;
    }

}
