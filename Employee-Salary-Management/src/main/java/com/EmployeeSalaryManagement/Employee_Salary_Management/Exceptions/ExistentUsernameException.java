package com.EmployeeSalaryManagement.Employee_Salary_Management.Exceptions;

public class ExistentUsernameException extends RuntimeException {
  public ExistentUsernameException(String message) {
    super(message);
  }
}
