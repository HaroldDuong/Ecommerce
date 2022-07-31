package com.mock.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rates")
public class RatesEntity {

    @EmbeddedId
    RatesKey ratesKey;

    @Id
    @GeneratedValue
    private Integer id;

    private String review;

    private int starNumber;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private CustomersEntity customers;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductsEntity products;

}
