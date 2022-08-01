package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.PaypalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * author: CuongTTC
 * */

@Repository
public interface PaypalRepo extends JpaRepository<PaypalDetail, Long> {
    PaypalDetail findByPaymentId(Long paymentId);
    Long countByPaymentId(Long paymentId);

}
