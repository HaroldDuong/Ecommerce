package com.mock.ecommerce.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "brands")
public class BrandsEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;



}
