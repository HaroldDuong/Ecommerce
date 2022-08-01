package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.CustomerOrder;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

/**
 * author CuongTTC
 *
 * */

@Service
@Transactional
public class OrderService implements DAO<CustomerOrder> {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<CustomerOrder> findALl() {
        return orderRepo.findAll();
    }

    @Override
    public CustomerOrder findById(Long id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public void save(CustomerOrder vo) {
        orderRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

    public int numberNewOrder(){
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        return orderRepo.countOrderToday(day, month,year);

    }
}
