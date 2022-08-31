package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Order;
import com.app.acmedelivery.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{

    private final OrderRepository orderRepository;
    @Override
    public JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }
}
