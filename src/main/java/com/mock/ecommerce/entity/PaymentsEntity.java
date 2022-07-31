package com.mock.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Data
@Table(name = "payments")
public class PaymentsEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private Double amount;

    private LocalDateTime paymentDate;

    private String paymentMethod;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CustomerOrderEntity customerOrder;

    @OneToMany(mappedBy = "payments", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<PaypalDetailsEntity> paypalDetailsEntities;

}
