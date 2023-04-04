package com.krs.ecommerce.Repositories;

import com.krs.ecommerce.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Override
    List<OrderItem> findAll();

    @Override
    <S extends OrderItem> S save(S entity);

    @Override
    Optional<OrderItem> findById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);
}
