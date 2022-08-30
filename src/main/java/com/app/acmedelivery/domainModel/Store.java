package com.app.acmedelivery.domainModel;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@ToString(callSuper = true)
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

    @Transient
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}