package com.application.aled.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.application.aled.entity.Company;
import com.application.aled.repository.CompanyRepository;
import com.application.aled.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;

    @GetMapping("/company")
    public List<Company> getAllCompanies() {
        System.out.println("Get all companies...");

        List<Company> companies = companyService.getAllCompany();
        return companies;
    }

    @PutMapping(value = "/company/create")
    public void putCompany(@RequestBody Company company){
        System.out.println("Create company...");
        companyService.addCompany(company);
    }
}
