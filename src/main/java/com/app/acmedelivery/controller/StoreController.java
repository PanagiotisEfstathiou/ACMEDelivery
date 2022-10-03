package com.app.acmedelivery.controller;

import com.app.acmedelivery.domainModel.Product;
import com.app.acmedelivery.domainModel.Store;
import com.app.acmedelivery.domainModel.StoreCategory;
import com.app.acmedelivery.repository.StoreRepository;
import com.app.acmedelivery.service.BaseService;
import com.app.acmedelivery.service.StoreService;
import com.app.acmedelivery.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController extends AbstractController<Store>{

    private final StoreService storeService;
	private final StoreRepository storeRepository;

    @Override
    public BaseService<Store> getBaseService() {
        return storeService;
    }



	@CrossOrigin(origins = "*")
	@GetMapping("stores/catalog/{id}")
	public Store getCatalog(@PathVariable Long id){
		return this.storeService.getLazy(id);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("stores")
	public List <Store> getStores(){
		return this.storeService.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping("stores/{id}")
	public ResponseEntity<Store> getStore(@PathVariable Long id){
		Store store = storeService.get(id);
		return new ResponseEntity<Store>(store , HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("stores/searchName/{storeName}")
	public Store searchByName(@PathVariable String storeName){
		return storeService.findByName(storeName);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("stores/searchCategory/{storeCategory}")
	public Store searchByCategory(@PathVariable String storeCategory){
		return storeService.findByCategory(StoreCategory.valueOf(storeCategory.toUpperCase()));
	}



}



