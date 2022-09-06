package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface StoreService extends BaseService<Store> {

    Store findByStoreName(String StoreName);
    List<Store> mostFamousStores();
    List<Store> mostFamousStoresPerCategory();


}
