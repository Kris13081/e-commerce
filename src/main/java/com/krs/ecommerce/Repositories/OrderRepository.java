package com.krs.ecommerce.Repositories;

import com.krs.ecommerce.Model.Customer;
import com.krs.ecommerce.Model.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Override
    <S extends Order> S save(S entity);

    @Override
    Optional<Order> findById(Long aLong);

    @Override
    List<Order> findAll();

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Order entity);

    @Override
    void deleteAll();

    @Override
    List<Order> findAll(Sort sort);

    @Override
    Page<Order> findAll(Pageable pageable);

    @Override
    <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable);

    List<Order> findByCustomer(Customer customer);

}
