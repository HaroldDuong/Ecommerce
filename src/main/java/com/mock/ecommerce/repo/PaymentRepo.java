package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: CuongTTC
 * */
@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    //Payment findTopOneByCustomerOrderByPaymentDateDesc(Long customerId);

    //Long countByCustomerOrderId(Long customerId);

    @Query(value = "SELECT sum(p.amount) FROM payments p WHERE month(p.payment_date) = ?1 " +
            "AND year(p.payment_date) = ?2 AND p.status = true",nativeQuery = true)
    Double totalPriceInPaymentByMonthYear(int month, int year);

    @Query(value = "SELECT * FROM payments p INNER JOIN customer_order o ON p.customer_order_id = o.id " +
            "WHERE o.customer_id = ?1 " +
            "ORDER BY p.payment_date DESC ", nativeQuery = true)
    List<Payment> findAllByCustomerIdOrderPaymentDateDesc (Long customerId);
}
