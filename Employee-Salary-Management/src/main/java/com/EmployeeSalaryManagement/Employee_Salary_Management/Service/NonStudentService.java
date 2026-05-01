package com.EmployeeSalaryManagement.Employee_Salary_Management.Service;

import com.EmployeeSalaryManagement.Employee_Salary_Management.Entities.NonStudentEmployeeEntity;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Exceptions.IncorrectPeselNumberException;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Repositories.NonStudentRepository;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Requests.NonStudentEmployeeRequest;
import com.EmployeeSalaryManagement.Employee_Salary_Management.Responses.NonStudentEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class NonStudentService {
    @Autowired
            private NonStudentRepository nonStudentRepository;
    NonStudentEmployeeResponse nonStudentEmployeeResponse=new NonStudentEmployeeResponse();

    public double calculateNonStudentSalary(NonStudentEmployeeRequest nonStudentEmployeeRequest){
        NonStudentEmployeeEntity nonStudentEmployee=new NonStudentEmployeeEntity();
        double netSalary=0;
        //if the non student employee is between 18 to 26, will be deducted 22% from the base salary
        if(nonStudentEmployeeRequest.getAge()>=18 && nonStudentEmployeeRequest.getAge()<=26 && nonStudentEmployeeRequest.getContractType().equalsIgnoreCase("umowa zlecenie")){
            double taxAmount=nonStudentEmployeeRequest.getBaseSalary()*0.22;
            netSalary=(nonStudentEmployeeRequest.getBaseSalary()*nonStudentEmployeeRequest.getWorkedHours()-taxAmount)+nonStudentEmployeeRequest.getBonusAmount();
            nonStudentEmployee.setNetSalary(netSalary);
        }
        //if the non student employee is above 26years old and the contract is umowa zlecenie, it'll be deducted 20% from the base salary
        if(nonStudentEmployeeRequest.getAge()>26 && nonStudentEmployeeRequest.getContractType().equalsIgnoreCase("umowa zlecenie")){
            double taxAmount=nonStudentEmployeeRequest.getBaseSalary()*0.22;
             netSalary=(nonStudentEmployeeRequest.getBaseSalary()*nonStudentEmployeeRequest.getWorkedHours()-taxAmount)+nonStudentEmployeeRequest.getBonusAmount();
            nonStudentEmployee.setNetSalary(netSalary);
        }
        if(nonStudentEmployeeRequest.getAge()>=18 && nonStudentEmployeeRequest.getAge()<=26 && nonStudentEmployeeRequest.getContractType().equalsIgnoreCase("umowa o prace")){
            double taxAmount=nonStudentEmployeeRequest.getBaseSalary()*0.1371;
             netSalary=(nonStudentEmployeeRequest.getBaseSalary()-taxAmount)+ nonStudentEmployeeRequest.getBonusAmount();
            nonStudentEmployee.setNetSalary(netSalary);
        }
        if(nonStudentEmployeeRequest.getAge()>26 && nonStudentEmployeeRequest.getContractType().equalsIgnoreCase("umowa o prace")){
            double taxAmount=nonStudentEmployeeRequest.getBaseSalary()*0.22;
            netSalary=(nonStudentEmployeeRequest.getBaseSalary()-taxAmount)+nonStudentEmployeeRequest.getBonusAmount();
            nonStudentEmployee.setNetSalary(netSalary);
        }
       return netSalary;

    }
    public NonStudentEmployeeResponse createNonStudentEmployee(NonStudentEmployeeRequest nonStudentEmployeeRequest){
        //user request
        NonStudentEmployeeEntity nonStudentEmployee=new NonStudentEmployeeEntity();
nonStudentEmployee.setFullName(nonStudentEmployeeRequest.getFullName());
nonStudentEmployee.setAge(nonStudentEmployeeRequest.getAge());
nonStudentEmployee.setBaseSalary(nonStudentEmployeeRequest.getBaseSalary());
nonStudentEmployee.setDepartment(nonStudentEmployeeRequest.getDepartment());
nonStudentEmployee.setContractType(nonStudentEmployeeRequest.getContractType());
nonStudentEmployee.setPeselNumber(nonStudentEmployeeRequest.getPeselNumber());
nonStudentEmployee.setWorkedHours(nonStudentEmployeeRequest.getWorkedHours());
nonStudentEmployee.setBonusAmount(nonStudentEmployeeRequest.getBonusAmount());

nonStudentRepository.save(nonStudentEmployee);
double salary=calculateNonStudentSalary(nonStudentEmployeeRequest);
nonStudentEmployee.setNetSalary(salary);
nonStudentRepository.save(nonStudentEmployee);
//response from server

        nonStudentEmployeeResponse.setFullName(nonStudentEmployee.getFullName());
        nonStudentEmployeeResponse.setPeselNumber(nonStudentEmployee.getPeselNumber());
        nonStudentEmployeeResponse.setContractType(nonStudentEmployee.getContractType());
        nonStudentEmployeeResponse.setNetSalary(nonStudentEmployee.getNetSalary());
        nonStudentEmployeeResponse.setDepartment(nonStudentEmployee.getDepartment());
        return nonStudentEmployeeResponse;
    }
    public NonStudentEmployeeResponse getNonStudentEmployee(Long peselNumber){
        NonStudentEmployeeEntity nonStudentEmployee=new NonStudentEmployeeEntity();
        NonStudentEmployeeEntity studentEmployeeEntity=nonStudentRepository.findByPeselNumber(peselNumber)
                .orElseThrow(() -> new IncorrectPeselNumberException("employee with this pesel number not found!"));
        nonStudentEmployeeResponse.setFullName(nonStudentEmployee.getFullName());
        nonStudentEmployeeResponse.setPeselNumber(nonStudentEmployee.getPeselNumber());
        nonStudentEmployeeResponse.setContractType(nonStudentEmployee.getContractType());
        nonStudentEmployeeResponse.setNetSalary(nonStudentEmployee.getNetSalary());
        nonStudentEmployeeResponse.setDepartment(nonStudentEmployee.getDepartment());
        return nonStudentEmployeeResponse;
    }
    public NonStudentEmployeeResponse updateNonStudentEmployee(Long peselNumber, NonStudentEmployeeRequest nonStudentEmployeeRequest){
        NonStudentEmployeeEntity nonStudentEmployee=new NonStudentEmployeeEntity();
NonStudentEmployeeEntity nonStudentEmployeeEntity=nonStudentRepository.findByPeselNumber(peselNumber)
        .orElseThrow(() -> new IncorrectPeselNumberException("employee with this pesel number not found"));
        nonStudentEmployeeEntity.setFullName(nonStudentEmployeeRequest.getFullName());
        nonStudentEmployeeEntity.setAge(nonStudentEmployeeRequest.getAge());
        nonStudentEmployeeEntity.setContractType(nonStudentEmployeeRequest.getContractType());
        nonStudentEmployeeEntity.setBaseSalary(nonStudentEmployeeRequest.getBaseSalary());
        nonStudentEmployeeEntity.setBonusAmount(nonStudentEmployeeRequest.getBonusAmount());
        nonStudentEmployeeEntity.setNetSalary(nonStudentEmployeeRequest.getBaseSalary());
        nonStudentEmployeeEntity.setPeselNumber(nonStudentEmployeeRequest.getPeselNumber());
        nonStudentEmployeeEntity.setDepartment(nonStudentEmployeeRequest.getDepartment());
        nonStudentEmployeeEntity.setWorkedHours(nonStudentEmployeeRequest.getWorkedHours());
        nonStudentRepository.save(nonStudentEmployeeEntity);

        nonStudentEmployeeResponse.setFullName(nonStudentEmployee.getFullName());
        nonStudentEmployeeResponse.setPeselNumber(nonStudentEmployee.getPeselNumber());
        nonStudentEmployeeResponse.setContractType(nonStudentEmployee.getContractType());
        nonStudentEmployeeResponse.setNetSalary(nonStudentEmployee.getNetSalary());
        nonStudentEmployeeResponse.setDepartment(nonStudentEmployee.getDepartment());

        return nonStudentEmployeeResponse;
    }
    public void deleteNonStudentEmployee(Long peselNumber){
NonStudentEmployeeEntity nonStudentEmployeeEntity=nonStudentRepository.findByPeselNumber(peselNumber)
        .orElseThrow(() -> new IncorrectPeselNumberException("employee with this pesel number not found"));
nonStudentRepository.delete(nonStudentEmployeeEntity);

    }
}
