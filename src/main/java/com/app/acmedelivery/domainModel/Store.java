package com.app.acmedelivery.domainModel;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "STORE")
@SequenceGenerator(name = "storeIdGenerator", sequenceName = "STORE_SEQ", allocationSize = 1)
public class Store extends BaseModel {

    @Column(length=20, nullable=false)
    private String storeName;

    @Column(length=20, nullable = false)
    private String storeRegion;

    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable =false)
    @ElementCollection
    private List<ProductCategory> storeCategory;
   
    @OneToMany
    private List<Product> catalog;


}
