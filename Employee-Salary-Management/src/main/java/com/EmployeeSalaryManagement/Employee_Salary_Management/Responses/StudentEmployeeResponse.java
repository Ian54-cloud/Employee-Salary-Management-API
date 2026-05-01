package com.EmployeeSalaryManagement.Employee_Salary_Management.Responses;

import lombok.Data;

@Data
public class StudentEmployeeResponse {
    private String fullName;
    private Long peselNumber;
    private String contractType;
    private double netSalary;
    private String department;

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

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

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
}
