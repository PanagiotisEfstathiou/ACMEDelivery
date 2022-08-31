package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{
    @Override
    public JpaRepository<Order, Long> getRepository() {
        return null;
    }
}
