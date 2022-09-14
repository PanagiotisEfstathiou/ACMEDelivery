package com.app.acmedelivery.domainModel;


import lombok.*;

import javax.persistence.*;

import javax.persistence.Entity;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESSES")
@SequenceGenerator(name = "storeIdGenerator", sequenceName = "ADDRESS_SEQ", initialValue = 1, allocationSize = 1)
public class Address extends BaseModel{

    @Column(length=25, nullable = false)
    @NotNull
    private String streetName;

    @Column(length=15, nullable = false)
    @NotNull
    private Long telephone;

    @Column(length=3, nullable=false)
    @NotNull
    private int streetNumber;

    @Column(length=15, nullable = false)
    @NotNull
    private String region;

    @Column(length=2)
    private int floorNumber;
}
