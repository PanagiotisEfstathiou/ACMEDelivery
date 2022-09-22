package com.app.acmedelivery.domainModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDER_SEQ", allocationSize = 1)
public class Order extends BaseModel {



    @ManyToOne(fetch = FetchType.EAGER)
	@NotNull
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
	@NotNull
    private Store store;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    private List<OrderItem> orderItems;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date submitDate;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private PaymentMethod paymentMethod;

    @Column
    private String notes;
}
