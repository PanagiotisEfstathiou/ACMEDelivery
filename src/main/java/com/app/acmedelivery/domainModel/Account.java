package com.app.acmedelivery.domainModel;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT", indexes = {@Index(name = "ACCOUNT_IDX_01", columnList = "email, mobilePhone")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNT_SEQ", allocationSize = 1)

public class Account extends BaseModel {
    @Column(length = 20, nullable = false)
    private String firstName;
    @Column(length = 20, nullable = false)
    private String lastName;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;
    @Column(length = 15, nullable = false, unique = true)
    private Short mobilePhone;
    @Column(length = 15, nullable = false)
    private String password;


}
