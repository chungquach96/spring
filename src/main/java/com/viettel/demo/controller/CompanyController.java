package com.viettel.demo.controller;

import com.viettel.demo.dto.CompanyDto;
import com.viettel.demo.models.Company;
import com.viettel.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/com")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/getAllCompany")
    public ResponseEntity getAllCompany(){
        Pageable pageRequest = PageRequest.of(0, 1);
        List<Company> companies = companyService.getAllCompany(pageRequest);
        return new ResponseEntity(companies, HttpStatus.OK);
    }

    @PostMapping("/addCompany")
    public ResponseEntity addCompany(@RequestBody CompanyDto company){
        Company resp = companyService.addCompany(company);
        return new ResponseEntity(resp,HttpStatus.CREATED);
    }
}
