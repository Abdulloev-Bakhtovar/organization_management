Organization Management MVC Web Application

Status: In Development

This project is an Organization Management MVC web application built using the Spring Framework. It provides endpoints for managing companies, departments, and employees within an organization.
Technologies Used

    Spring Framework
    Maven
    MySQL
    Spring Data JPA
    Spring MVC

Project Structure

The project follows a standard Maven web application structure:

    config: Contains configuration classes (e.g., AppConfig for Spring configuration).
    controller: Contains controllers for handling web requests and rendering views.
    dao: Data Access Object layer for database interactions.
    entity: Entity classes representing data models.
    service: Business logic layer for processing data.
    Application.java: Main class to run the application.
    resources: Configuration files and properties.
        application.properties: Database and other application configurations.
        templates: HTML templates for rendering views.

How to Run

    Clone the repository.
    Configure your database connection in application.properties.
    Run the Application.java class to start the application.
    Access the application in your web browser at http://localhost:8080.

Views and Controllers

The application uses Spring MVC for handling requests and rendering views. Below are the available endpoints and their corresponding views:

    Companies:
        /companies: View a list of all companies.
        /companies/{companyId}: View details of a specific company.
        /companies/add: Add a new company.
        /companies/update/{companyId}: Update details of a specific company.
        /companies/delete/{companyId}: Delete a specific company.

    Departments:
        /departments: View a list of all departments.
        /departments/{departmentId}: View details of a specific department.
        /departments/add: Add a new department.
        /departments/update/{departmentId}: Update details of a specific department.
        /departments/delete/{departmentId}: Delete a specific department.

    Employees:
        /employees: View a list of all employees.
        /employees/{employeeId}: View details of a specific employee.
        /employees/add: Add a new employee.
        /employees/update/{employeeId}: Update details of a specific employee.
        /employees/delete/{employeeId}: Delete a specific employee.

Future Enhancements

    Implement better UI/UX with frontend frameworks like Bootstrap or React.
    Add form validation for user input.
    Implement security features such as authentication and authorization.

Feel free to contribute and improve this project!