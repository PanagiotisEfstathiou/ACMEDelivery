package com.app.acmedelivery.controller;

import com.app.acmedelivery.domainModel.Order;
import com.app.acmedelivery.service.BaseService;
import com.app.acmedelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController extends AbstractController<Order> {

	private final OrderService orderService;

	@Override
	public BaseService<Order> getBaseService() {
		return orderService;
	}
}
