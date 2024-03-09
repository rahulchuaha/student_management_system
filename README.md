Overview
The Student Management System is a web-based application built with Spring Boot,
MySQL database, Thymeleaf, and Lombok. It serves as a comprehensive solution for managing student information, providing functionalities such as creating,
retrieving, updating, and deleting student records.

Features
Create Student: Add new students to the database with ease.
Get Student: Retrieve detailed information about a student.
Update Student: Modify existing student records effortlessly.
Delete Student: Remove a student's information from the system securely.
Technologies Used
Spring Boot: Framework for building Java-based enterprise applications.
MySQL Database: Store and manage student data efficiently.
Thymeleaf: Server-side Java template engine for web and standalone environments.
Lombok: Reduces boilerplate code, improving code readability and conciseness.
Maven: Project management and comprehension tool.
Spring Data JPA: Simplifies database access using the Java Persistence API.
Project Structure
The project adheres to best practices and is organized with the following key components:

StudentController: Handles HTTP requests, interacts with the service layer.
StudentService: Contains business logic, communicates with the repository.
StudentRepository: Implements data access methods using Spring Data JPA.
StudentDTO and StudentMapper: Enhances data transfer and mapping between layers.
Frontend with Thymeleaf: Provides a user-friendly interface for managing student records.
