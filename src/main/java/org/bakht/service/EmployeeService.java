package org.bakht.service;

import org.bakht.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    void updateEmployee(Employee employee);
}
