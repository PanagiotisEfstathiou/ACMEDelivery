package com.app.acmedelivery.domainModel;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseModel {

    private OrderItem orderItem;
    private Date date;
    private Time time;
    private double totalPrice;
    private double discount;
    private Account account;


}
