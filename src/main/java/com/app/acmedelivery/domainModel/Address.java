package com.app.acmedelivery.domainModel;


import lombok.*;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESS")
@SequenceGenerator(name = "storeIdGenerator", sequenceName = "ADDRESS_SEQ", initialValue = 1, allocationSize = 1)
public class Address extends BaseModel{
    @Column(length=25, nullable = false)
    private String streetName;

    @Column(length=15, nullable = false)
    private Long telephone;

    @Column(length=3, nullable=false)
    private int addressNumber;

    @Column(length=15, nullable = false)
    private String region;

    @Column(length=2, nullable=true)
    private int floorNumber;
}
