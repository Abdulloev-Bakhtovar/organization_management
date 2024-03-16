package org.bakht.dao;

import org.bakht.model.Department;

import java.util.List;

public interface DepartmentDAO {
    List<Department> getAllDepartments();
    Department getDepartmentById(int id);
    void addDepartment(Department department);
    void deleteDepartment(int departmentId);
    void updateDepartment(Department department);
}
