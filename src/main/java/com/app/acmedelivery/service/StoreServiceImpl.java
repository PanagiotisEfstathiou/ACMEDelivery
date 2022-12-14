package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.domainModel.StoreCategory;
import com.app.acmedelivery.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
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


	public Store getLazy(Long id){
		 Optional<Store> store = storeRepository.getLazy(id);
		if (store.isPresent()){
			return store.get();
		}
		throw new NoSuchElementException(String.format("There was no store found matching id %d."));
	}

	@Override
	public List<Store> findAll(){
		 List<Store> find = storeRepository.findAll();
		for (final Store store : find) {
			store.setCatalog(null);
		}
		return find;
	}

	public Store findByName(String storeName){
		Store store = storeRepository.findByStoreName(storeName);
			store.setCatalog(null);
			return store;
	}

	public Store findByCategory(StoreCategory storeCategory){
		Store store = storeRepository.findByStoreCategory(storeCategory);
			store.setCatalog(null);
			return store;
	}
}
