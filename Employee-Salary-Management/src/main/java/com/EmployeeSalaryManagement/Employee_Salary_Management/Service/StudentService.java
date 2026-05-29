package com.EmployeeSalaryManagement.Employee_Salary_Management.Service;

import com.EmployeeSalaryManagement.Employee_Salary_Management.Entities.StudentEmployeeEntity;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Exceptions.IncorrectPeselNumberException;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Repositories.StudentRepository;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Requests.StudentEmployeeRequest;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Responses.StudentEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
@Autowired
        private StudentRepository student;

    StudentEmployeeResponse studentEmployeeResponse = new StudentEmployeeResponse();


    public double calculateSalary(StudentEmployeeRequest studentRequest) {
        StudentEmployeeEntity studentEmployee = new StudentEmployeeEntity();
        double netSalary=0;
        if (studentRequest.getAge() >= 18 && studentRequest.getAge() <= 26 && studentRequest.getContractType().equalsIgnoreCase("umowa zlecenie")) {
            netSalary = (studentRequest.getWorkedHours() * studentRequest.getBaseSalary()) + studentRequest.getBonusAmount();
            studentEmployee.setNetSalary(netSalary);
        }

        if (studentRequest.getAge() >= 18 && studentRequest.getAge() <= 26 && studentRequest.getContractType().equalsIgnoreCase("umowa o prace")) {
            double taxAmount = studentRequest.getBaseSalary() * 0.13;
            //netSalary = (studentRequest.getBaseSalary() - taxAmount) + studentRequest.getBonusAmount();
            netSalary=(studentRequest.getBaseSalary()-taxAmount *studentRequest.getWorkedHours())+studentRequest.getBonusAmount();
            studentEmployee.setNetSalary(netSalary);
        }
        if(studentRequest.getAge()>26 && studentRequest.getContractType().equalsIgnoreCase("umowa zlecenie")){
            double taxAmount = studentRequest.getBaseSalary()*0.27;
            //netSalary = (studentRequest.getBaseSalary()* studentRequest.getWorkedHours()-taxAmount)+ studentRequest.getBonusAmount();
            netSalary=(studentRequest.getBaseSalary()-taxAmount * studentRequest.getWorkedHours())+studentRequest.getBonusAmount();
            studentEmployee.setNetSalary(netSalary);
        }
        String formattedPeselNumber=String.valueOf(studentRequest.getPeselNumber());
        if(formattedPeselNumber.length()!=11){
            throw new IncorrectPeselNumberException("the pesel number must be 11-digits");
        }
        Long pesel=Long.valueOf(formattedPeselNumber);
        studentEmployee.setPeselNumber(pesel);
        if(studentRequest.getAge()>26 && studentRequest.getContractType().equalsIgnoreCase("umowa o prace")){
            double taxAmount = studentRequest.getBaseSalary() * 0.27;
            netSalary = (studentRequest.getBaseSalary() - taxAmount) + studentRequest.getBonusAmount();
            studentEmployee.setNetSalary(netSalary);
        }
        return netSalary;
    }

    public StudentEmployeeResponse createStudentEmployee(StudentEmployeeRequest studentRequest) {
        //request
        StudentEmployeeEntity studentEmployee = new StudentEmployeeEntity();
        studentEmployee.setFullName(studentRequest.getFullName());
        studentEmployee.setAge(studentRequest.getAge());
        studentEmployee.setContractType(studentRequest.getContractType());
        studentEmployee.setAge(studentRequest.getAge());
        studentEmployee.setBonusAmount(studentRequest.getBonusAmount());
        studentEmployee.setPeselNumber(studentRequest.getPeselNumber());
        studentEmployee.setDepartment(studentRequest.getDepartment());
        student.save(studentEmployee);
        //calculate salary
        double salary = calculateSalary(studentRequest);
        studentEmployee.setNetSalary(salary);
//save to database
        student.save(studentEmployee);


        //response

        studentEmployeeResponse.setFullName(studentEmployee.getFullName());
        studentEmployeeResponse.setPeselNumber(studentEmployee.getPeselNumber());
        studentEmployeeResponse.setContractType(studentEmployee.getContractType());
        studentEmployeeResponse.setNetSalary(studentEmployee.getNetSalary());
        studentEmployeeResponse.setDepartment(studentEmployee.getDepartment());

        return studentEmployeeResponse;

    }

    public StudentEmployeeResponse getStudentByPesel(Long peselNumber) {
        StudentEmployeeEntity studentEmployee = student.findByPeselNumber(peselNumber)
                .orElseThrow(() -> new IncorrectPeselNumberException("student employee with this pesel not found"));
        studentEmployeeResponse.setFullName(studentEmployee.getFullName());
        studentEmployeeResponse.setPeselNumber(studentEmployee.getPeselNumber());
        studentEmployeeResponse.setContractType(studentEmployee.getContractType());
        studentEmployeeResponse.setNetSalary(studentEmployee.getNetSalary());
        studentEmployeeResponse.setDepartment(studentEmployee.getDepartment());
        return studentEmployeeResponse;
    }
    public StudentEmployeeResponse updateStudentByPesel(Long peselNumber, StudentEmployeeRequest studentEmployeeRequest){
        StudentEmployeeEntity studentEmployee = new StudentEmployeeEntity();
        StudentEmployeeEntity studentEmployeeEntity=student.findByPeselNumber(peselNumber)
                .orElseThrow(() -> new IncorrectPeselNumberException("pesel number not found"));
        studentEmployeeEntity.setFullName(studentEmployeeRequest.getFullName());
        studentEmployeeEntity.setAge(studentEmployeeRequest.getAge());
        studentEmployeeEntity.setContractType(studentEmployeeRequest.getContractType());
        studentEmployeeEntity.setBaseSalary(studentEmployeeRequest.getBaseSalary());
        studentEmployeeEntity.setBonusAmount(studentEmployeeRequest.getBonusAmount());
        studentEmployeeEntity.setNetSalary(studentEmployeeRequest.getBaseSalary());
        studentEmployeeEntity.setPeselNumber(studentEmployeeRequest.getPeselNumber());
        studentEmployeeEntity.setDepartment(studentEmployeeRequest.getDepartment());
        studentEmployeeEntity.setWorkedHours(studentEmployeeRequest.getWorkedHours());

        student.save(studentEmployeeEntity);
        studentEmployeeResponse.setFullName(studentEmployee.getFullName());
        studentEmployeeResponse.setPeselNumber(studentEmployee.getPeselNumber());
        studentEmployeeResponse.setContractType(studentEmployee.getContractType());
        studentEmployeeResponse.setNetSalary(studentEmployee.getNetSalary());
        studentEmployeeResponse.setDepartment(studentEmployee.getDepartment());

        return studentEmployeeResponse;
    }
    public void deleteStudentByPesel(Long peselNumber){
        StudentEmployeeEntity studentEmployeeEntity=student.findByPeselNumber(peselNumber)
                .orElseThrow(() -> new IncorrectPeselNumberException("pesel number not found"));

        student.delete(studentEmployeeEntity);
    }
}
