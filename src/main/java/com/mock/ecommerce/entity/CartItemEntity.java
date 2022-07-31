package com.mock.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "cart_item")
public class CartItemEntity {


    @Id
    @GeneratedValue
    private Integer id;

    private int sellingQuantity;

    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ProductsEntity products;
}
