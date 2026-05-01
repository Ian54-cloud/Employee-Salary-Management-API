package com.EmployeeSalaryManagement.Employee_Salary_Management.Exceptions;

public class IncorrectPeselNumberException extends RuntimeException {
    public IncorrectPeselNumberException(String message) {
        super(message);
    }
}
