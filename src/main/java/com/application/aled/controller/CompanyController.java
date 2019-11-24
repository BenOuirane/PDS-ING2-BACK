package com.application.aled.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.application.aled.entity.Company;
import com.application.aled.repository.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CompanyController {

    CompanyRepository repository;

    @GetMapping("/companies")
    public List<Company> getAllCompanies() {
        System.out.println("Get all companies...");

        List<Company> companies = new ArrayList<Company>();
        repository.findAll().forEach(companies::add);
        return companies;
    }

    @PutMapping(value = "/company/create")
    public Company putCompany(@RequestBody Company company){
        System.out.println("Create company...");
        Company _company = repository.save(new Company(company.getName()));
        return company;
    }
}
