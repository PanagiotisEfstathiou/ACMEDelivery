package com.app.acmedelivery.domainModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@SequenceGenerator(name = "idGenerator", sequenceName = "Product_SEQ", initialValue = 1, allocationSize = 1)
public class Product extends BaseModel {

    @Column(length = 50, nullable = false)
    @NotNull
    private String name;

    @Column
    @NotNull
    private BigDecimal price;

    @Column(length = 150, nullable = false)
    private String description;


	@JsonBackReference("store")
    @NotNull
    @ManyToOne()
    private Store store;




    @Column(length = 50, nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;




}
