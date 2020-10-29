package com.viettel.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.viettel.demo.models.Client; 
// This is an Interface.
// No need Annotation here.
public interface ClientRepository extends JpaRepository<Client, Long> { // Long: Type of Client ID.
 
    Client findByCliNo(String cliNo);
    
    @Query("SELECT c from Client c where c.fullName like %?1% ")
    List<Client> findByFullNameLike(String fullName);
 
//    List<Client> findByBirthDayGreaterThan(Date birthday);

    @Query("SELECT coalesce(max(c.id), 0) FROM Client c")
    Long getMaxId();
 
}