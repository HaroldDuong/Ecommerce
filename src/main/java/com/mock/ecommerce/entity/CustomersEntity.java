package com.mock.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "customers")
public class CustomersEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String address;

    private String firstName;

    private String lastName;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UsersEntity users;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<CustomerOrderEntity> customerOrderEntities;

    @OneToMany(mappedBy = "customers")
    Set<RatesEntity> ratesEntitySet;

}
