package com.mock.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "customer_order")
public class CustomerOrderEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String deliverCustomerAddress;

    private String deliverCustomerName;

    private String deliverCustomerPhone;

    private LocalDate orderDate;

    private Boolean status;

    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CustomersEntity customers;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<PaymentsEntity> paymentsEntities;

    @ManyToMany
    Set<CartItemEntity> cartItemEntities;

}
