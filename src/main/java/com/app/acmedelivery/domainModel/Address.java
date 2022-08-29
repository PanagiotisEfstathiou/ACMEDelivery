package com.app.acmedelivery.domainModel;


import lombok.*;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address extends BaseModel{
    private String streetName;
    private Long telephone;
    private int addressNumber;
    private String region;
    private int floorNumber;
}
