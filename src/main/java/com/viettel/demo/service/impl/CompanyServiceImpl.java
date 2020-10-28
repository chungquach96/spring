package com.viettel.demo.service.impl;

import com.viettel.demo.dto.CompanyDto;
import com.viettel.demo.models.Company;
import com.viettel.demo.models.Staff;
import com.viettel.demo.repository.CompanyRepository;
import com.viettel.demo.repository.StaffRepository;
import com.viettel.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private StaffRepository staffRepository;


    @Override
    public List<Company> getAllCompany(Pageable pageable) {
        return companyRepository.findAll(pageable).getContent();
    }

    @Override
    public Company addCompany(CompanyDto dto) {
        Company c = new Company();
        Staff s = new Staff();
        s.setName(dto.getStaff().getName());
        s.setAddress(dto.getStaff().getAddress());
        Staff staffResp = staffRepository.save(s);
        c.setName(dto.getName());
        c.setStaff(staffResp);
        c.setPhonenumber(dto.getPhoneNumber());
        return companyRepository.save(c);
    }
}
