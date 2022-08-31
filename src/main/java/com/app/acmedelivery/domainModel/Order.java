package com.app.acmedelivery.domainModel;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
@SequenceGenerator(name = "orderIdGenerator", sequenceName = "ORDER_SEQ", allocationSize = 1)
public class Order extends BaseModel {

    @ManyToOne
    @NotNull
    private Account account;

    @OneToMany(cascade = CascadeType.ALL)
    @NotNull
    private List<OrderItem> orderItems;

    @Column(nullable = false)
    @NotNull
    private Date timestamp;

    @Column(nullable = false)
    @NotNull
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    @NotNull
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    @NotNull
    private String notes;
}