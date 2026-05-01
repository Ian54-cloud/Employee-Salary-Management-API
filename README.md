# Employee-Salary-Management-API

## Description
This project is a RESTful API built with Spring Boot for managing employee salary data, with support for different employee types (students and non-students). The system handles employee records, salary calculations, and basic validation such as PESEL number correctness.
The API separates business logic based on employee type, allowing different handling of salary rules and data structures. It follows a layered architecture (Controller → Service → Repository) and uses DTOs for clean request/response handling.

## Features
1.Manage employees (students and non-students)
2.CRUD operations for employee records
3.Salary handling based on employee type
4.Clean separation of concerns (Controller, Service, Repository layers)
5.Docker support for easy deployment

## Technologies used
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Docker & Docker Compose
- REST API design principles

## Architecture
Controllers – handle HTTP requests
Services – business logic
Repositories – database access
Entities – database models
DTOs (Requests/Responses) – data transfer


