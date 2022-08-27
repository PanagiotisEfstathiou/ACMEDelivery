package com.app.acmedelivery.domainModel;

import lombok.*;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem extends BaseModel{

    private Product product;
    private double price;
    private String notes;
}
