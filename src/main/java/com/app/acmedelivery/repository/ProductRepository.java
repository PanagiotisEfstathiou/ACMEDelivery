package com.app.acmedelivery.repository;

import com.app.acmedelivery.domainModel.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findBySerial(String serial);
}
