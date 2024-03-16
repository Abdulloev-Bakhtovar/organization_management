package org.bakht.dao.impl;

import org.bakht.dao.EmployeeDAO;
import org.bakht.model.Department;
import org.bakht.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> getAllEmployees() {
        final String sqlQuery = "SELECT emp.employee_id, emp.name AS employee_name, emp.salary, " +
                "depar.name AS department_name " +
                "FROM employee AS emp " +
                "JOIN department AS depar ON emp.department_id = depar.department_id";

        return jdbcTemplate.query(sqlQuery, (resultSet, rowNum) -> {
            Employee employee = new Employee();
            Department department = new Department();
            employee.setEmployeeId(resultSet.getInt("employee_id"));
            employee.setName(resultSet.getString("employee_name"));
            employee.setSalary(resultSet.getBigDecimal("salary"));
            department.setName(resultSet.getString("department_name"));
            employee.setDepartment(department);

            return employee;
        });
    }

  @Override
  public Employee getEmployeeById(int id) {
      final String sqlQuery = "SELECT emp.employee_id, emp.name AS employee_name, emp.salary," +
              " depar.name AS department_name " +
              "FROM employee AS emp " +
              "JOIN department AS depar ON emp.department_id = depar.department_id " +
              "WHERE emp.employee_id = ?";
      return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, (resultSet, rowNum) -> {
          Employee employee = new Employee();
          Department department = new Department();
          employee.setEmployeeId(resultSet.getInt("employee_id"));
          employee.setName(resultSet.getString("employee_name"));
          employee.setSalary(resultSet.getBigDecimal("salary"));
          department.setName(resultSet.getString("department_name"));
          employee.setDepartment(department);

          return employee;
      });
  }

    @Override
    public void addEmployee(Employee employee) {
        String sqlQuery = "INSERT INTO employee (name, salary, department_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlQuery, employee.getName(), employee.getSalary(),
                employee.getDepartment().getDepartmentId());
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String sqlQuery = "DELETE FROM employee WHERE employee_id = ?";
        jdbcTemplate.update(sqlQuery, employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sqlQuery = "UPDATE employee SET name = ?, salary = ?, department_id = ? WHERE employee_id = ?";
        jdbcTemplate.update(sqlQuery, employee.getName(), employee.getSalary(),
                employee.getDepartment().getDepartmentId(), employee.getEmployeeId());
    }

}
