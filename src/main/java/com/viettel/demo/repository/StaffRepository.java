package com.viettel.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.viettel.demo.models.Staff;
 
// This is an Interface.
// No need Annotation here.
public interface StaffRepository extends CrudRepository<Staff, Long> {
    @Override
    <S extends Staff> S save(S entity);

    @Override
    <S extends Staff> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Staff> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<Staff> findAll();

    @Override
    Iterable<Staff> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Staff entity);

    @Override
    void deleteAll(Iterable<? extends Staff> entities);

    @Override
    void deleteAll();
}