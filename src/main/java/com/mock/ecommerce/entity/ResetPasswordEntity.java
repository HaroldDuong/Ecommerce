package com.mock.ecommerce.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reset_password")
public class ResetPasswordEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String resetToken;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UsersEntity users;

}
