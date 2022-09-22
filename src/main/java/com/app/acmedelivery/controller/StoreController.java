package com.app.acmedelivery.controller;

import com.app.acmedelivery.domainModel.Product;
import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.service.BaseService;
import com.app.acmedelivery.service.StoreService;
import com.app.acmedelivery.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("stores")
public class StoreController extends AbstractController<Store>{

    private final StoreService storeService;
    @Override
    public BaseService<Store> getBaseService() {
        return storeService;
    }

	@GetMapping(value = "stores/catalog")
	@ResponseBody
	public ResponseEntity<ApiResponse<List<Product>>> getCatalog(@RequestParam Store store){

		final List<Product> catalog =  store.getCatalog();

		return ResponseEntity.ok(ApiResponse.<List<Product>>builder().data(catalog).build());
	}



}
