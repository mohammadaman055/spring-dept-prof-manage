# Department-Professor Management System

This Spring Boot application manages departments and professors with a many-to-many association.

## Endpoints

### Create Department

- **POST** `/departments`

### Create Professor

- **POST** `/departments/professors`

### Assign Professor to Department

- **POST** `/departments/{departmentId}/professors/{professorId}`

### Get All Departments

- **GET** `/departments`

### Get Professors by Department Name

- **GET** `/departments/professors/{departmentName}`

## Setup

1. Clone the repository.
2. Configure `application.properties` for database connection.
3. Build and run the application using Maven or your preferred IDE.

## Usage

- Use the provided endpoints to manage departments and professors.
- Ensure proper JSON formats for requests and responses.
- Handle exceptions and errors gracefully.
