package org.bakht.controller;

import org.bakht.model.Company;
import org.bakht.model.Department;
import org.bakht.service.CompanyService;
import org.bakht.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    private final CompanyService companyService;
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(CompanyService companyService, DepartmentService departmentService) {
        this.companyService = companyService;
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public String getAllDepartments(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);

        return "department/all-departments";
    }

    @GetMapping("/details")
    public String getDepartmentDetails(@RequestParam("departmentId") int departmentId, Model model) {
        Department department = departmentService.getDepartmentById(departmentId);
        if (department != null) {
            model.addAttribute("department", department);

            return "department/department-details";
        } else {
            return "redirect:/departments/all";
        }
    }

    @GetMapping("/add")
    public String showAddDepartmentForm(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("department", new Department());
        model.addAttribute("companies",companies);

        return "department/add-department";
    }

    @PostMapping("/add")
    public String addDepartment(@ModelAttribute("department") Department department,
                                @RequestParam("companyId") int companyId) {
        Company company = companyService.getCompanyById(companyId);
        department.setCompany(company);
        departmentService.addDepartment(department);

        return "redirect:/departments/all";
    }

    @GetMapping("/update")
    public String showUpdateDepartmentForm(@RequestParam("departmentId") int departmentId, Model model) {
        List<Company> companies = companyService.getAllCompanies();
        Department department = departmentService.getDepartmentById(departmentId);
        if (department != null && !companies.isEmpty()) {
            model.addAttribute("department", department);
            model.addAttribute("companies", companies);

            return "department/update-department";
        } else {
            return "redirect:/departments/all";
        }
    }

    @PostMapping("/update")
    public String updateDepartment(@ModelAttribute("department") Department department,
                                   @RequestParam("companyId") int companyId) {
        Company company = companyService.getCompanyById(companyId);
        department.setCompany(company);
        departmentService.updateDepartment(department);

        return "redirect:/departments/all";
    }

    @PostMapping("/delete")
    public String deleteDepartment(@RequestParam("departmentId") int departmentId) {
        departmentService.deleteDepartment(departmentId);

        return "redirect:/departments/all";
    }
}
