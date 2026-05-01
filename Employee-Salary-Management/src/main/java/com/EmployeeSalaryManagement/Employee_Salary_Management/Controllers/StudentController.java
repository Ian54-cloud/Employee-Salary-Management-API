package com.EmployeeSalaryManagement.Employee_Salary_Management.Controllers;

import com.EmployeeSalaryManagement.Employee_Salary_Management.Entities.StudentEmployeeEntity;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Requests.StudentEmployeeRequest;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Responses.StudentEmployeeResponse;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/studentemployee")
    public ResponseEntity<StudentEmployeeResponse>addStudentEmployee(@RequestBody StudentEmployeeRequest student){
        StudentEmployeeResponse studentEmployeeResponse= studentService.createStudentEmployee(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentEmployeeResponse);
    }
    @GetMapping("/studentemployee/{peselNumber}")
    public ResponseEntity<StudentEmployeeResponse>getStudentEmployeeByPeselNumber(@PathVariable Long peselNumber){
        StudentEmployeeResponse studentEmployeeResponse=studentService.getStudentByPesel(peselNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentEmployeeResponse);
    }
    @PutMapping("/studentemployee/{peselNumber}")
    public ResponseEntity<StudentEmployeeResponse>updateStudent(@PathVariable Long peselNumber, @RequestBody StudentEmployeeRequest studentEmployeeRequest){
        StudentEmployeeResponse updated=studentService.updateStudentByPesel(peselNumber, studentEmployeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(updated);
    }
    @DeleteMapping("/studentemployee/{peselNumber}")
    public ResponseEntity<Object>deleteStudent(@PathVariable Long peselNumber){
        studentService.deleteStudentByPesel(peselNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body("deleted!");
    }
}
