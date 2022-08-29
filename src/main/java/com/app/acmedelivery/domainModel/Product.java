package com.app.acmedelivery.domainModel;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.catalog.Catalog;

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
