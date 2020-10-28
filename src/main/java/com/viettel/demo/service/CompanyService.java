package com.viettel.demo.service;

import com.viettel.demo.dto.CompanyDto;
import com.viettel.demo.models.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany(Pageable pageable);
    Company addCompany(CompanyDto dto);

}
