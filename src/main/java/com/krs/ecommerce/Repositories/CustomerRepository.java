package com.krs.ecommerce.Repositories;

import com.krs.ecommerce.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Override
    <S extends Customer> S save(S entity);

    @Override
    Optional<Customer> findById(Long aLong);

    @Override
    List<Customer> findAll();

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);
}
