package com.app.acmedelivery.domainModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cart extends BaseModel{

    private List<Product> orderItems;
    private double cartPrice;
    private Account account;


}
