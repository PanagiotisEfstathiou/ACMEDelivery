package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Product;
import com.app.acmedelivery.domainModel.Store;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;


public interface ProductService extends  BaseService<Product> {

    Product findBySerial(String serial);


}
