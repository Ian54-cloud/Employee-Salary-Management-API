package com.EmployeeSalaryManagement.Employee_Salary_Management.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message="the username mustn't be empty")
    private String username;
    @NotBlank(message="the password mustn't be empty")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
