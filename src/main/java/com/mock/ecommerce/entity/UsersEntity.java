package com.mock.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
public class UsersEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String email;

    private Boolean enabled;

    private String password;

    private String role;

    private String userName;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<ResetPasswordEntity> resetPasswordEntities;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<CustomersEntity> customersEntities;
}
