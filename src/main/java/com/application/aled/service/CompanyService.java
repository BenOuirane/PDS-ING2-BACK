package com.application.aled.service;

import com.application.aled.entity.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> getAllCompany();
    public void addCompany(Company company);

}
