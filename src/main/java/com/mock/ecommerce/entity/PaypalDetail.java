package com.mock.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * author CuongTTC
 * */

@Entity
@Table(name = "paypal_details")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class PaypalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionId;
    private String payerEmail;
    private String payreRecipentName;
    private String payerCity;
    private String payerCountry;
    private String payerPostalCode;
    private String payerState;

    @OneToOne(targetEntity = com.mock.ecommerce.entity.Payment.class)
    private Payment payment;

    public PaypalDetail(String transactionId, String payerEmail, String payreRecipentName, String payerCity, String payerCountry, String payerPostalCode, String payerState, Payment payment) {
        this.transactionId = transactionId;
        this.payerEmail = payerEmail;
        this.payreRecipentName = payreRecipentName;
        this.payerCity = payerCity;
        this.payerCountry = payerCountry;
        this.payerPostalCode = payerPostalCode;
        this.payerState = payerState;
        this.payment = payment;
    }
}
