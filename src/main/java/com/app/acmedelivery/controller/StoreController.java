package com.app.acmedelivery.controller;

import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.service.BaseService;
import com.app.acmedelivery.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("stores")
public class StoreController extends AbstractController<Store>{

    private final StoreService storeService;
    @Override
    public BaseService<Store> getBaseService() {
        return storeService;
    }
}
