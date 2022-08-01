package com.mock.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
* author: CuongTTC1
* */
@Entity
@Table(name = "customer")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    @OneToOne(targetEntity = User.class)
    private User user;

    public Customer(String firstName, String lastName, String phoneNumber, String address, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.user = user;
    }
}
