package com.app.acmedelivery.domainModel;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class OrderItem extends BaseModel{
    
    @ManyToOne
    private Product product;
    private int quantity;
    private double price;
    private String notes;
}
