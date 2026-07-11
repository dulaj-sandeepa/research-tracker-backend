# Research Tracker - Backend

This is the backend service for the Research Tracker application, built using Java and the Spring Boot framework. It provides a robust RESTful API to manage research projects, documents, user authentication, and milestones.

---

## Tech Stack & Architecture

- Framework: Spring Boot (Java)
- Build Tool: Maven (utilizing pom.xml and the Maven wrapper mvnw)
- Architecture: Layered Controller-Service-Repository Pattern
- Database: Relational Database (Configured via application.properties)

---

## Project Structure

The project follows a standard Spring Boot package layout:

src/main/java/lk/ijse/cmjd/researchtracker/
- controller/ (REST API Endpoints for Project, User, Document, Test)
- repository/ (Spring Data JPA Repositories for Database communication)
- service/ (Business Logic Layer interfaces & implementations)
- dto/ (Data Transfer Objects for Request/Response bodies)
- project/ (Main application entry point & Core entities)

---

## Prerequisites

Before running the application, ensure you have the following installed:
- Java Development Kit (JDK): Version 17 or higher
- Maven: Installed locally (or use the included ./mvnw wrapper)
- Database: MySQL or PostgreSQL instance running

---

## Getting Started

1. Configure the Database
Open src/main/resources/application.properties and configure your database connection strings:

spring.datasource.url=jdbc:mysql://localhost:3306/research_tracker_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

2. Run the Application
Open your terminal inside this root directory and execute the following command:

For Windows Command Prompt/PowerShell: mvnw.cmd spring-boot:run
For Linux/macOS: ./mvnw spring-boot:run

The server will boot up by default on port 8080.

---

## API Endpoints Overview

The backend exposes endpoints to handle the CRUD operations across the system:

- Authentication (/api/v1/auth/*): User signup, login, and identity management
- Projects (/api/v1/projects): Creating, updating, and fetching research tracks
- Documents (/api/v1/documents): Managing files, reference materials, and versions
- Milestones (/api/v1/milestones): Tracking progress targets and due dates

---

## Running Tests
To run unit and integration tests defined in the src/test/ directory, execute: mvn clean test

