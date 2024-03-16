package org.bakht.controller;

import org.bakht.model.Company;
import org.bakht.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/all")
    public String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);

        return "company/all-companies";
    }

    @GetMapping("/details")
    public String getCompanyDetails(@RequestParam("companyId") int companyId, Model model) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            model.addAttribute("company", company);

            return "company/company-details";
        } else {
            return "redirect:/companies/all";
        }
    }

    @GetMapping("/add")
    public String showAddCompanyForm(Model model) {
        model.addAttribute("company", new Company());

        return "company/add-company";
    }

    @PostMapping("/add")
    public String addCompany(@ModelAttribute("company") Company company) {
        companyService.addCompany(company);

        return "redirect:/companies/all";
    }

    @GetMapping("/update")
    public String showUpdateCompanyForm(@RequestParam("companyId") int companyId, Model model) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            model.addAttribute("company", company);

            return "company/update-company";
        } else {
            return "redirect:/companies/all";
        }
    }

    @PostMapping("/update")
    public String updateCompany(@ModelAttribute("company") Company company) {
        companyService.updateCompany(company);

        return "redirect:/companies/all";
    }

    @PostMapping("/delete")
    public String deleteCompany(@RequestParam("companyId") int companyId) {
        companyService.deleteCompany(companyId);

        return "redirect:/companies/all";
    }
}
