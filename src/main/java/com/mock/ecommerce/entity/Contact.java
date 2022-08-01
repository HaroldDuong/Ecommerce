package com.mock.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * author: CuongTTC
* **/

@Entity
@Table(name = "contact")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String subject;
    private boolean status;

    @Column(columnDefinition = "LONGTEXT")
    private  String message;

    @Column(columnDefinition = "LONGTEXT")
    private String reply;

    @PrePersist
    void setStatus(){
        this.status = false;
    }
}
