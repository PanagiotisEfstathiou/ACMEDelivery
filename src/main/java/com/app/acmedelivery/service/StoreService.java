package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Product;
import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService extends BaseService<Store> {

    Store findByStoreName(String StoreName);
    List<Store> mostFamousStores();
    List<Store> mostFamousStoresPerCategory();

	List<Product> getCatalog(Store store);


}
