package com.viettel.demo.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.viettel.demo.models.Staff;
 
// This is an Interface.
// No need Annotation here.
public interface StaffRepository extends CrudRepository<Staff, Long> { 

}