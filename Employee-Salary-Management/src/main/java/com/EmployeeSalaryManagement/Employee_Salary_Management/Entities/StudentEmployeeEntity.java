package com.EmployeeSalaryManagement.Employee_Salary_Management.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="student_employee_entity")
public class StudentEmployeeEntity {
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

    //authorization
    private String username;
    private String password;




    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    public double getWorkedHours() {
        return workedHours;
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

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }
}
