package org.bakht.service;

import org.bakht.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);
    void addDepartment(Department department);
    void deleteDepartment(int departmentId);
    void updateDepartment(Department department);
}
