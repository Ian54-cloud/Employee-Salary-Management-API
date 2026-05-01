package com.EmployeeSalaryManagement.Employee_Salary_Management.Controllers;

import com.EmployeeSalaryManagement.Employee_Salary_Management.Requests.NonStudentEmployeeRequest;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Responses.NonStudentEmployeeResponse;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Responses.StudentEmployeeResponse;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Service.NonStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NonStudentController {
    @Autowired
    private NonStudentService nonStudentService;
    @PostMapping("/non-student-employee")
    public ResponseEntity<NonStudentEmployeeResponse> addNonStudentEmployee(@RequestBody NonStudentEmployeeRequest nonStudentEmployeeRequest){
        NonStudentEmployeeResponse nonStudentEmployeeResponse=nonStudentService.createNonStudentEmployee(nonStudentEmployeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nonStudentEmployeeResponse);
    }
    @GetMapping("/non-student-employee/{peselNumber}")
    public ResponseEntity<NonStudentEmployeeResponse> getNonStudentEmployee(@PathVariable Long peselNumber){
        NonStudentEmployeeResponse nonStudentEmployeeResponse=nonStudentService.getNonStudentEmployee(peselNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(nonStudentEmployeeResponse);

    }
    @PutMapping("/non-student-employee/{peselNumber}")
    public ResponseEntity<NonStudentEmployeeResponse> updateNonStudentEmployee(@PathVariable Long peselNumber, @RequestBody NonStudentEmployeeRequest nonStudentEmployeeRequest){
        NonStudentEmployeeResponse nonStudentEmployeeResponse=nonStudentService.updateNonStudentEmployee(peselNumber, nonStudentEmployeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nonStudentEmployeeResponse);
    }
    @DeleteMapping("/non-student-employee/{peselNumber}")
    public ResponseEntity<Object>deleteNonStudentEmployee(@PathVariable Long peselNumber){
        nonStudentService.deleteNonStudentEmployee(peselNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body("deleted");

    }
}
