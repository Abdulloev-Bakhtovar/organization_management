package org.bakht.dao;

import org.bakht.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void addEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    void updateEmployee(Employee employee);
}
