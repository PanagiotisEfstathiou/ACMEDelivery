package com.app.acmedelivery.domainModel;

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
@Table(name = "ORDER")
@SequenceGenerator(name = "orderIdGenerator", sequenceName = "ORDER_SEQ", initialValue = 1, allocationSize = 1)
public class Order extends BaseModel {

    @ManyToOne
    private Account account;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Column(nullable = false)
    private String notes;
}