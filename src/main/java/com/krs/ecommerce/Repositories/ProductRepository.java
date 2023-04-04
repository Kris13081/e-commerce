package com.krs.ecommerce.Repositories;

import com.krs.ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

        @Override
        public <S extends Product> S save(S entity);

        @Override
        public Optional<Product> findById(Long aLong);

        @Override
        public void deleteById(Long aLong);

}
