package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 * author: CuongTTC
 * */

@Repository
public interface OrderRepo extends JpaRepository<CustomerOrder, Long> {
    @Query(value = "select count(*) from CustomerOrder o where day(o.orderDate) = ?1" +
            "and month(o.orderDate) =?2 and year(o.orderDate) = ?3 and o.status = true", nativeQuery = true)
    int countOrderToday(int day, int month, int year);
}
