package com.app.acmedelivery.controller;

import com.app.acmedelivery.domainModel.Product;
import com.app.acmedelivery.service.BaseService;
import com.app.acmedelivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController extends AbstractController<Product> {

	private final ProductService productService;

	@Override
	public BaseService<Product> getBaseService() {
		return productService;
	}
}
