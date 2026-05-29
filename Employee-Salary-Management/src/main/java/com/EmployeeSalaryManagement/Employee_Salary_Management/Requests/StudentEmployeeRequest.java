package com.EmployeeSalaryManagement.Employee_Salary_Management.Requests;

import lombok.Data;

@Data
public class StudentEmployeeRequest {
    private String fullName;
    private Long peselNumber;
    private String contractType;
    private double baseSalary;
    private int age;
    private String department;
    private double workedHours;
    private double bonusAmount;



    public void setPeselNumber(Long peselNumber) {
        this.peselNumber = peselNumber;
    }

    public Long getPeselNumber() {
        return peselNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
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
}
