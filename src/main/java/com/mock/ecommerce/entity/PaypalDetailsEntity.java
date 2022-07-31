package com.mock.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "paypal_details")
public class PaypalDetailsEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String payerCity;

    private String payerCountry;

    private String payerEmail;

    private String payerPostalCode;

    private String payerRecipientName;

    private String payerState;

    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private PaymentsEntity payments;

}
