package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * author CuongTTC
 * */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Long countByUserId(Long userId);
    Customer findByUserId(Long userId);
}
