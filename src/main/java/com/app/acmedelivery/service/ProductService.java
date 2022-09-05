package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Product;

public interface ProductService extends  BaseService<Product> {

Product findBySerial(String serial);

}
