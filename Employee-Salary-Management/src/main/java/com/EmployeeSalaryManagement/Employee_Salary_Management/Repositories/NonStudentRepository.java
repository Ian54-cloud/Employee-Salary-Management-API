package com.EmployeeSalaryManagement.Employee_Salary_Management.Repositories;

import com.EmployeeSalaryManagement.Employee_Salary_Management.Entities.NonStudentEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NonStudentRepository extends JpaRepository<NonStudentEmployeeEntity, UUID> {

    Optional<NonStudentEmployeeEntity> findByPeselNumber(Long peselNumber);
}
