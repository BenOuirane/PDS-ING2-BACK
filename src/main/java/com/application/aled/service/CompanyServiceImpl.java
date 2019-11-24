package com.application.aled.service;

import com.application.aled.entity.Company;
import com.application.aled.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

public class CompanyServiceImpl implements CompanyService{
    private CompanyRepository repository;


    @Override
    public List<Company> getAllCompany() {
        System.out.println("Get all Companies...");
        List<Company> companies = new ArrayList<>();
        repository.findAll().forEach(companies::add);

        return companies;
    }

    @Override
    public void addCompany(Company company) {
        System.out.println("Create Company...");
        repository.save(company);
    }
}
