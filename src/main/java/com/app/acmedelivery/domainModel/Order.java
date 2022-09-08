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
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
@SequenceGenerator(name = "orderIdGenerator", sequenceName = "ORDER_SEQ", allocationSize = 1)
public class Order extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Store store;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @NotNull
    private List<OrderItem> orderItems;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @NotNull
    private Date submitDate;

    @Column(precision = 10, scale = 2, nullable = false)
    @NotNull
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    @NotNull
    private PaymentMethod paymentMethod;

    @Column
    private String notes;
}