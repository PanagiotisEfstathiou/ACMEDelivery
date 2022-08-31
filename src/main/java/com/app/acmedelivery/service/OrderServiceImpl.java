package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Account;
import com.app.acmedelivery.domainModel.Order;
import com.app.acmedelivery.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{

    private final OrderRepository orderRepository;
    @Override
    public JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    public Order initiateOrder(Account account){
        return Order.builder().account(account).orderItems(new ArrayList<>()).build();
    }
}
