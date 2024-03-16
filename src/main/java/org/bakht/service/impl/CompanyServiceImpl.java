package org.bakht.service.impl;

import org.bakht.dao.CompanyDAO;
import org.bakht.model.Company;
import org.bakht.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDAO companyDAO;

    @Autowired
    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    @Override
    public Company getCompanyById(int id) {
        return companyDAO.getCompanyById(id);
    }

    @Override
    public void addCompany(Company company) {
        companyDAO.addCompany(company);
    }

    @Override
    public void deleteCompany(int companyId) {
        companyDAO.deleteCompany(companyId);
    }

    @Override
    public void updateCompany(Company company) {
        companyDAO.updateCompany(company);
    }
}

