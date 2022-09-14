package com.app.acmedelivery.domainModel;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNTS", indexes = {@Index(name = "ACCOUNT_IDX_01", columnList = "email, mobilePhone")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNT_SEQ", initialValue = 1, allocationSize = 1)

public class Account extends BaseModel {
    @Column(length = 20, nullable = false)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$"
            , message = "Your name contains special characters, are you Elon Musks son?")
    private String firstName;

    @Column(length = 20, nullable = false)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$"
            , message = "Your last name contains special characters")
    private String lastName;

    @Column(length = 50)
    @Size(max = 50)
    private String address;



    @Column(length = 50, nullable = false, unique = true)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"
            , message = "Please input valid email")
    private String email;

    @Column(length = 15, nullable = false, unique = true)
    @NotNull
    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",
            message = "Your phone number must be 10 digits.")
    private String mobilePhone;

    @Column(length = 15, nullable = false)
    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"
            , message = "Minimum eight characters, at least one letter and one number")
    private String password;
}
