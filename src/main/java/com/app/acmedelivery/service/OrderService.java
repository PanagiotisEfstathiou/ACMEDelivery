package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.Account;
import com.app.acmedelivery.domainModel.Order;
import com.app.acmedelivery.domainModel.PaymentMethod;
import com.app.acmedelivery.domainModel.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrderService extends  BaseService<Order>{

    Order initiateOrder(Account account);

    void addItem(Order order, Product product, int quantity);

    void updateItem(Order order, Product product, int quantity);

    void removeItem(Order order, Product product);

    Order checkout(Order order, PaymentMethod paymentMethod, BigDecimal orderTotalPrice);

    List<Order> findBySubmitDate(Date submitDate);
}
