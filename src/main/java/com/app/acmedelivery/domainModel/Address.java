package com.app.acmedelivery.domainModel;


import lombok.*;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseModel{
    private String address;
    private int floor;
    private Long telephone;
    private int addressNumber;
    private String region;
    private String name;
    private int floorNumber;
}
