package org.bakht.dao;

import org.bakht.model.Company;

import java.util.List;

public interface CompanyDAO {
    List<Company> getAllCompanies();
    Company getCompanyById(int id);
    void addCompany(Company company);
    void deleteCompany(int companyId);
    void updateCompany(Company company);
}
