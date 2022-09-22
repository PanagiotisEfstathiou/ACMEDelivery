package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Product;
import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.repository.StoreRepository;
import com.app.acmedelivery.service.BaseServiceImpl;
import com.app.acmedelivery.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService {
    private final StoreRepository storeRepository;

    @Override
    public JpaRepository<Store, Long> getRepository() {
        return storeRepository;
    }

    public Store findByStoreName(final String storeName) {

        return storeRepository.findByStoreName(storeName);
    }


    @Override
    public List<Store> mostFamousStores() {
        return storeRepository.mostFamousStores();
    }

    @Override
    public List<Store> mostFamousStoresPerCategory() {
        return storeRepository.mostFamousStoresPerCategory();
    }


	public List<Product> getCatalog(Store store){
		Optional <List<Product>> catalog = Optional.ofNullable(store.getCatalog());
		if (catalog.isPresent()){
			return catalog.get();
		}
		throw new NoSuchElementException("Not available");
	}
}
