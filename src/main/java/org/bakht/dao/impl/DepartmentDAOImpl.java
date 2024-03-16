package org.bakht.dao.impl;

import org.bakht.dao.DepartmentDAO;
import org.bakht.model.Company;
import org.bakht.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public DepartmentDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Department> getAllDepartments() {
        final String sqlQuery = "SELECT d.department_id, " +
                "d.name AS department_name, c.name AS company_name" +
                " FROM department AS d " +
                "JOIN company AS c ON d.company_id = c.company_id";
        return jdbcTemplate.query(sqlQuery, (resultSet, rowNum) -> {
            Company company = new Company();
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt("department_id"));
            department.setName(resultSet.getString("department_name"));
            company.setName(resultSet.getString("company_name"));
            department.setCompany(company);

            return department;
        });
    }

    @Override
    public Department getDepartmentById(int id) {
        final String sqlQuery = "SELECT d.department_id, " +
                "d.name AS department_name, c.name AS company_name" +
                " FROM department AS d " +
                "JOIN company AS c ON d.company_id = c.company_id" +
                " WHERE department_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, (resultSet, rowNum) -> {
            Company company = new Company();
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt("department_id"));
            department.setName(resultSet.getString("department_name"));
            company.setName(resultSet.getString("company_name"));
            department.setCompany(company);

            return department;
        });
    }

    @Override
    public void addDepartment(Department department) {
        final String sqlQuery = "INSERT INTO department (name, company_id) VALUES (?, ?)";
        jdbcTemplate.update(sqlQuery, department.getName(), department.getCompany().getCompanyId());
    }

    @Override
    public void deleteDepartment(int departmentId) {
        final String sqlQuery = "DELETE FROM department WHERE department_id = ?";
        jdbcTemplate.update(sqlQuery, departmentId);
    }

    @Override
    public void updateDepartment(Department department) {
        final String sqlQuery = "UPDATE department SET name = ?, company_id = ? WHERE department_id = ?";
        jdbcTemplate.update(sqlQuery, department.getName(), department.getCompany().getCompanyId(),
                department.getDepartmentId());
    }
}
