package com.app.acmedelivery.domainModel;

import lombok.*;

import javax.persistence.Entity;
import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order extends BaseModel {

    private Cart orderItem;
    private Date date;
    private Time time;
    private double discount;
    private double totalPrice;
}
