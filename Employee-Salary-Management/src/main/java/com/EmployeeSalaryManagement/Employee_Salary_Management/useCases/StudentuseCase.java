package com.EmployeeSalaryManagement.Employee_Salary_Management.useCases;

import com.EmployeeSalaryManagement.Employee_Salary_Management.Dtos.LoginRequest;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Dtos.RegistrationRequest;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Entities.StudentEmployeeEntity;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Exceptions.ExistentUsernameException;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Exceptions.InvalidPasswordException;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Exceptions.UsernameNotFoundException;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Repositories.StudentRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentuseCase {
    @Value("${security.token.secret}")
    private String secretKey;
private StudentRepository studentRepository;
private PasswordEncoder passwordEncoder;
public StudentuseCase(StudentRepository studentRepository, PasswordEncoder passwordEncoder){
    this.studentRepository=studentRepository;
    this.passwordEncoder=passwordEncoder;
}
public String registerStudent(RegistrationRequest registrationRequest){
    boolean registration=studentRepository.existsByUsername(registrationRequest.getUsername());
    if(registration){
        throw new ExistentUsernameException("this username already exists");
    }

    StudentEmployeeEntity studentEmployee=new StudentEmployeeEntity();
    studentEmployee.setUsername(registrationRequest.getUsername());
    studentEmployee.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
    studentEmployee.setFullName(registrationRequest.getFullName());
    studentRepository.save(studentEmployee);
    //create a token
    Algorithm algorithm=Algorithm.HMAC256(secretKey);
    String token=JWT.create().withIssuer("employee-salary-management-api")
            //extract id from database
            .withSubject(studentEmployee.getId().toString())
            .sign(algorithm);
    return token;
}
public String loginStudent(LoginRequest loginRequest){
    StudentEmployeeEntity username=studentRepository.findByUsername(loginRequest.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("this username doesn't exist"));
    var password=passwordEncoder.matches(loginRequest.getPassword(), username.getPassword());
    if(!password){
        throw new InvalidPasswordException("this password is wrong");
    }
    Algorithm algorithm=Algorithm.HMAC256(secretKey);
    String token=JWT.create().withIssuer("employee-salary-management-api")
            //extract id from database
            .withSubject(username.getId().toString())
            .sign(algorithm);
    return token;
}

    }


