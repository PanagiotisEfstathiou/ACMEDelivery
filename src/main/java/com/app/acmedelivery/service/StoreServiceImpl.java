package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService{

    @Override
    public JpaRepository<Store, Long> getRepository() {
        return null;
    }

    @Override
    public int totalRating() {
        return 0;
    }
}
