package com.viettel.demo.repository;

import com.viettel.demo.models.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company,Long> {

//    List<Company> Find(Pageable pageable);

}
