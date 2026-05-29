# Employee-Salary-Management-API
A RESTful API built with Java 17 and Spring Boot for managing employees and automating net salary calculations based on Polish contract types.

### Authentication
- User registration with BCrypt password encryption
- JWT token generation on registration and login (HMAC256)
- Protected endpoints requiring valid token

### Salary Management
- Automated net salary calculation based on:
  - Contract type (Umowa Zlecenie / Umowa o Pracę)
  - Age bracket (under 26 / over 26)
  - Tax deductions, worked hours, and bonus amounts
- PESEL number validation (11-digit format)

### Employee Management
- Full CRUD operations for student and non-student employees
- PESEL-based employee lookup
- Separate salary logic per employee category

### Exception Handling
- Custom exceptions for duplicate usernames, invalid PESEL, wrong password
- Global exception handler returning proper HTTP status codes (400, 409)

## Tech Stack
- Java 17
- Spring Boot
- Spring Security 
- JWT (auth0) 
- BCrypt 
- Spring Data JPA 
- PostgreSQL
- Docker 
- Maven 



