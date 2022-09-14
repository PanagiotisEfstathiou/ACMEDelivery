package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Product;
import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    public Product findBySerial(String serial){
        return productRepository.findBySerial(serial);
    }

}
