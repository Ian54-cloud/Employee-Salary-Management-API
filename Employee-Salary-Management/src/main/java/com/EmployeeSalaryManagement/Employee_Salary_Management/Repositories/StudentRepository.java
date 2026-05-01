package com.EmployeeSalaryManagement.Employee_Salary_Management.Repositories;

import com.EmployeeSalaryManagement.Employee_Salary_Management.Entities.StudentEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEmployeeEntity, UUID> {
    Optional<StudentEmployeeEntity> findByPeselNumber(Long peselNumber);
}
