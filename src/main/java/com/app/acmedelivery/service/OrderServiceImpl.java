package com.app.acmedelivery.service;

import com.app.acmedelivery.domainModel.*;
import com.app.acmedelivery.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{

    private final OrderRepository orderRepository;
    @Override
    public JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    public Order initiateOrder(Account account, Store store){
        return Order.builder().account(account).store(store).orderItems(new ArrayList<>()).build();
    }


	//add item must not be void, it has to return an order.
	// Every time it must return a post request OR it must be implemented in the front end
    @Override
    public void addItem(Order order, Product product, int quantity){
        if(checkNullability(order, product)){
            return;
        }

        boolean increasedQuantity = false;

        // If product is already contained in the order, don't add it again, just increase the quantity accordingly
        for (OrderItem oi : order.getOrderItems()) {
            if (oi.getProduct().getDescription().equals(product.getDescription())) {
                oi.setQuantity(oi.getQuantity() + quantity);
                increasedQuantity = true;
                break;
            }
        }

        if (!increasedQuantity) {
            order.getOrderItems().add(newOrderItem(order, product, quantity, product.getPrice()));
        }

        logger.debug("Product[{}] added to Order[{}]", product, order);
    }

    private boolean checkNullability(Order order, Product product) {
        if (order == null) {
            logger.warn("Order is null.");
            return true;
        }
        if (product == null) {
            logger.warn("Product is null.");
            return true;
        }
        return false;
    }

    @Override
    public void updateItem(Order order, Product product, int quantity) {
        if (checkNullability(order, product)) {
            return;
        }

        order.getOrderItems().removeIf(oi -> oi.getProduct().getDescription().equals(product.getDescription()));
        order.getOrderItems().add(newOrderItem(order, product, quantity,product.getPrice()));

        logger.debug("Product[{}] updated in Order[{}]", product, order);
    }

    private OrderItem newOrderItem(Order order, Product product, int quantity, BigDecimal price) {
        return OrderItem.builder().product(product).order(order).quantity(quantity).price(product.getPrice()).build();
    }

    @Override
    public void removeItem(Order order, Product product)
    {
        if (checkNullability(order, product))
        {
            return;
        }

        order.getOrderItems().removeIf(oi -> oi.getProduct().getDescription().equals(product.getDescription()));
        logger.debug("Product[{}] removed from Order[{}]", product, order);
    }

	public BigDecimal calculateTotalPrice(List<OrderItem> orderItems){
		BigDecimal sum = BigDecimal.ZERO;
		for (OrderItem orderItem : orderItems) {

			BigDecimal initialPrice = orderItem.getPrice();
			float res = sum.floatValue() + initialPrice.floatValue() * orderItem.getQuantity();
			sum = BigDecimal.valueOf(res);
		}
		return sum;
	}

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public Order checkout(Order order, PaymentMethod paymentMethod) {
        if (!validate(order)) {
            logger.warn("Order should have Account, order items, payment type and cost defined before being able to " +
                    "checkout the order.");
            return null;
        }

        // Set all order fields with proper values
        order.setPaymentMethod(paymentMethod);
        order.setSubmitDate(new Date());
        order.setTotalPrice(calculateTotalPrice(order.getOrderItems()));
        return create(order);
    }
    private boolean validate(Order order) {
        return order != null && !order.getOrderItems().isEmpty() && order.getAccount() != null;
    }

    @Override
    public List<Order> findBySubmitDate(final Date submitDate) {
        return null;
    }


	public List<Order> findAll(){return orderRepository.findAll();}




}
