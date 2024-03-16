package org.bakht.controller;

import org.bakht.model.Employee;
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

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "all-employees";
    }

    @GetMapping("/details")
    public String getEmployeeDetails(@RequestParam("empId") int empId, Model model) {
        Employee employee = employeeService.getEmployeeById(empId);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee-details";
        } else {
            return "redirect:/employees/all";
        }
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees/all";
    }

    @GetMapping("/update")
    public String showUpdateEmployeeForm(@RequestParam("empId") int empId, Model model) {
        Employee employee = employeeService.getEmployeeById(empId);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "update-employee";
        } else {
            return "redirect:/employees/all";
        }
    }


    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        System.out.println(employee);
        employeeService.updateEmployee(employee);
        return "redirect:/employees/all";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("empId") int empId) {
        employeeService.deleteEmployee(empId);
        return "redirect:/employees/all";
    }
}
