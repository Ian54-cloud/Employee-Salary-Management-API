package com.EmployeeSalaryManagement.Employee_Salary_Management.Exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
