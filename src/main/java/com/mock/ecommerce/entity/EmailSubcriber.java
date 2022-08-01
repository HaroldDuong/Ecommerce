package com.mock.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * author: CuongTTC
 * */

@Entity
@Table(name = "email_subcriber")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class EmailSubcriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

}
