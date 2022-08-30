package com.app.acmedelivery.domainModel;


import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel {
    private String productName;
    private double price;

}
