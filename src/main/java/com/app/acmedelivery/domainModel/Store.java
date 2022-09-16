package com.app.acmedelivery.domainModel;

import com.app.acmedelivery.domainModel.BaseModel;
import com.app.acmedelivery.domainModel.Product;
import com.app.acmedelivery.domainModel.StoreCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "STORES", indexes = {@Index(name = "STORE_IDX_01", columnList = "storeName")})
@SequenceGenerator(name = "idGenerator", sequenceName = "STORE_SEQ", allocationSize = 1)
@NoArgsConstructor
public class Store extends BaseModel {

    @Column(nullable=false, unique = true)
    private String storeName;

    @Column(nullable = false)
    private String storeRegion;


    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable =false)
    private StoreCategory storeCategory;


    @Column
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> catalog;





}
