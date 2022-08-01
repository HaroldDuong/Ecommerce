package com.mock.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * author : CuongTTC
 *
 * */
@Entity
@Table(name = "type")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date updated;
    private boolean enabled;

    @PrePersist
    void updated(){
        this.updated = new Date();
    }
}
