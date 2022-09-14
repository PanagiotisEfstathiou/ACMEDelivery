package com.app.acmedelivery.domainModel;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseModel {

    @Column(length = 50, nullable = false)
    @NotNull
    private String name;

    @Column(precision = 10, scale = 2, nullable = false)
    @NotNull
    private BigDecimal price;

    @Column(length = 50, nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    private ProductCategory productCategory;

    @ManyToOne(optional = false)
    @NotNull
    private Store store;

}
