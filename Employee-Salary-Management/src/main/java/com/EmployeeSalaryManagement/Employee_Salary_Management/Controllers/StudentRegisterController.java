package com.EmployeeSalaryManagement.Employee_Salary_Management.Controllers;

import com.EmployeeSalaryManagement.Employee_Salary_Management.Dtos.RegistrationRequest;
import com.EmployeeSalaryManagement.Employee_Salary_Management.useCases.StudentuseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class StudentRegisterController {
    private StudentuseCase studentuseCase;
    public StudentRegisterController(StudentuseCase studentuseCase){
        this.studentuseCase=studentuseCase;
    }
    @PostMapping("/student-register")
    public ResponseEntity<String> create(@RequestBody RegistrationRequest registrationRequest){
String token=studentuseCase.registerStudent(registrationRequest);
return ResponseEntity.status(HttpStatus.CREATED).body(token);
    }
}
