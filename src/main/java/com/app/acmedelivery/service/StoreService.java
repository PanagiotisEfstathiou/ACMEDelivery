package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Product;
import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.domainModel.StoreCategory;
import com.app.acmedelivery.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService extends BaseService<Store> {

    Store findByName(String storeName);

	Store findByCategory(StoreCategory storeCategory);


	Store getLazy(Long id);


}
