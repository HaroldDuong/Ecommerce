package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author CuongTTC
 * */
@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, Long> {


    //CustomerOrder findTopOneCustomerIdOrderByOrderDateDesc(Long customerId);

    //List<CustomerOrder> findByCustomerIdOrderByOrderDateDesc (Long customerId);

}
