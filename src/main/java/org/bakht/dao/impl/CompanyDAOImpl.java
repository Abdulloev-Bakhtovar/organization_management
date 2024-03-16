package org.bakht.dao.impl;

import org.bakht.dao.CompanyDAO;
import org.bakht.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public CompanyDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Company> getAllCompanies() {
        final String sqlQuery = "SELECT * FROM company";
        return jdbcTemplate.query(sqlQuery, (resultSet, rowNum) -> {
            Company company = new Company();
            company.setCompanyId(resultSet.getInt("company_id"));
            company.setName(resultSet.getString("name"));

            return company;
        });
    }

    @Override
    public Company getCompanyById(int id) {
        final String sqlQuery = "SELECT * FROM company WHERE company_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, (resultSet, rowNum) -> {
            Company company = new Company();
            company.setCompanyId(resultSet.getInt("company_id"));
            company.setName(resultSet.getString("name"));

            return company;
        });
    }

    @Override
    public void addCompany(Company company) {
        final String sqlQuery = "INSERT INTO company (name) VALUES (?)";
        jdbcTemplate.update(sqlQuery, company.getName());
    }

    @Override
    public void deleteCompany(int companyId) {
        final String deleteCompanyQuery = "DELETE FROM company WHERE company_id = ?";
        jdbcTemplate.update(deleteCompanyQuery, companyId);
    }


    @Override
    public void updateCompany(Company company) {
        final String sqlQuery = "UPDATE company SET name = ? WHERE company_id = ?";
        jdbcTemplate.update(sqlQuery, company.getName(), company.getCompanyId());
    }
}

