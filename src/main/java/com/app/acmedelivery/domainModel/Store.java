package com.app.acmedelivery.domainModel;

import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "STORES")
@Builder
@SequenceGenerator(name = "storeIdGenerator", sequenceName = "STORE_SEQ", allocationSize = 1)
public class Store extends BaseModel {

    @Column(length=20, nullable=false)
    private String storeName;

    @Column(length=20, nullable = false)
    private String storeRegion;

    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable =false)
    @ElementCollection
    private List<StoreCategory> storeCategory;


    @OneToMany(mappedBy = "store")
    private Set<Product> catalog;


    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable =false)
    @ElementCollection
    private List<Rating> ratings;

}
