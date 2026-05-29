package com.EmployeeSalaryManagement.Employee_Salary_Management.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<String> handleExistentUsername(ExistentUsernameException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }

    // new exception
    @ExceptionHandler(IncorrectPeselNumberException.class)
    public ResponseEntity<String> handleIncorrectPesel(IncorrectPeselNumberException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
}
