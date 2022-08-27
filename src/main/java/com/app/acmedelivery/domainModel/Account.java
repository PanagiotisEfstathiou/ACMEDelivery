package com.app.acmedelivery.domainModel;

import lombok.*;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseModel {

    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private Long mobilePhone;
    private String password;


}
