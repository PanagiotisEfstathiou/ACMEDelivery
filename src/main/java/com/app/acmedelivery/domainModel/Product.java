package com.app.acmedelivery.domainModel;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel {
    @Column(length = 30, nullable = false, unique = true)
    private String serial;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

}
