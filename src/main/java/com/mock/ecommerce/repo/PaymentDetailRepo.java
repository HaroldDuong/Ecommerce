package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.PaypalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * author CuongTTC
 * */
@Repository
public interface PaymentDetailRepo extends JpaRepository<PaypalDetail, Long> {
}
