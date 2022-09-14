package com.app.acmedelivery.repository;

import com.app.acmedelivery.domainModel.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findBySerial(String serial);
}
