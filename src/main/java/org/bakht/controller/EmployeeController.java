package org.bakht.controller;

import org.bakht.model.Department;
import org.bakht.model.Employee;
import org.bakht.service.DepartmentService;
import org.bakht.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        return "employee/all-employees";
    }

    @GetMapping("/details")
    public String getEmployeeDetails(@RequestParam("empId") int empId, Model model) {
        Employee employee = employeeService.getEmployeeById(empId);
        if (employee != null) {
            model.addAttribute("employee", employee);

            return "employee/employee-details";
        } else {
            return "redirect:/employees/all";
        }
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departments);

        return "employee/add-employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee,
                              @RequestParam("departmentId") int departmentId) {
        Department department = departmentService.getDepartmentById(departmentId);
        employee.setDepartment(department);
        employeeService.addEmployee(employee);

        return "redirect:/employees/all";
    }

    @GetMapping("/update")
    public String showUpdateEmployeeForm(@RequestParam("empId") int empId, Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        Employee employee = employeeService.getEmployeeById(empId);
        if (employee != null && !departments.isEmpty()) {
            model.addAttribute("employee", employee);
            model.addAttribute("departments", departments);

            return "employee/update-employee";
        } else {
            return "redirect:/employees/all";
        }
    }


    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee,
                                 @RequestParam("departmentId") int departmentId) {
        Department department = departmentService.getDepartmentById(departmentId);
        employee.setDepartment(department);
        employeeService.updateEmployee(employee);

        return "redirect:/employees/all";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("empId") int empId) {
        employeeService.deleteEmployee(empId);

        return "redirect:/employees/all";
    }
}
