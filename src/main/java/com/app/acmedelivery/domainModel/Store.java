package com.app.acmedelivery.domainModel;

import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString(callSuper = true)
@RequiredArgsConstructor
@Entity
@Table(name = "STORES")
@Builder
@SequenceGenerator(name = "storeIdGenerator", sequenceName = "STORE_SEQ", allocationSize = 1)
public class Store extends BaseModel {

    @Column(length=20, nullable=false)
    @NotNull
    private String name;

    @Column(length=20, nullable = false)
    @NotNull
    private String region;

    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable =false)
    @NotNull
    @ElementCollection
    private List<StoreCategory> storeCategory;


    @OneToMany(mappedBy = "store")
    @NotNull
    private Set<Product> products;


    @Enumerated(EnumType.STRING)
    @Column(length=15, nullable =false)
    @NotNull
    @ElementCollection
    private List<Rating> ratings;

}
