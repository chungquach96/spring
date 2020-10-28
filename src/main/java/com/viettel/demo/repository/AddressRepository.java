package com.viettel.demo.repository;

import com.viettel.demo.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address,Long> {
    @Override
    <S extends Address> S save(S entity);

    @Override
    <S extends Address> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Address> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<Address> findAll();

    @Override
    Iterable<Address> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Address entity);

    @Override
    void deleteAll(Iterable<? extends Address> entities);

    @Override
    void deleteAll();
}
