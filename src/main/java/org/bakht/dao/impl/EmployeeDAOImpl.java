package org.bakht.dao.impl;

import org.bakht.dao.EmployeeDAO;
import org.bakht.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Employee> getAllEmployees() {
        final String sqlQuery = "select * from employee;";

        return jdbcTemplate.query(sqlQuery, (resultSet, rowNum) -> {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("employee_id"));
            employee.setName(resultSet.getString("name"));
            employee.setSalary(resultSet.getBigDecimal("salary"));
            employee.setDepartmentId(resultSet.getInt("department_id"));
            return employee;
        });
        /*final String sqlQuery = "SELECT e.employee_id, e.name, e.salary, d.department_name " +
                "FROM employee e " +
                "JOIN department d ON e.department_id = d.department_id";

        return jdbcTemplate.query(sqlQuery, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setName(rs.getString("name"));
            employee.setSalary(rs.getBigDecimal("salary"));
            employee.setDepartmentName(rs.getString("department_name"));
            return employee;
        });*/
    }

    @Override
    public Employee getEmployeeById(int id) {
        final String sqlQuery = "select * from employee where employee_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, (resultSet, rowNum) -> {
            Employee emp = new Employee();
            emp.setEmployeeId(resultSet.getInt("employee_id"));
            emp.setName(resultSet.getString("name"));
            emp.setSalary(resultSet.getBigDecimal("salary"));
            emp.setDepartmentId(resultSet.getInt("department_id"));

            return emp;
        });
    }

    @Override
    public void addEmployee(Employee employee) {
        String sqlQuery = "INSERT INTO employee (name, salary, department_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlQuery, employee.getName(), employee.getSalary(), employee.getDepartmentId());
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String sqlQuery = "DELETE FROM employee WHERE employee_id = ?";
        jdbcTemplate.update(sqlQuery, employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sqlQuery = "UPDATE employee SET name = ?, salary = ?, department_id = ? WHERE employee_id = ?";
        jdbcTemplate.update(sqlQuery, employee.getName(), employee.getSalary(), employee.getDepartmentId(), employee.getEmployeeId());
    }
}
