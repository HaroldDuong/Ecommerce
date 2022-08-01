package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.CustomerOrder;
import com.mock.ecommerce.repo.CustomerOrderRepo;
import com.mock.ecommerce.repo.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: CuongTTC
 * */

@Service
@Transactional
public class CustomerOrderService implements DAO<CustomerOrder> {

    private final CustomerOrderRepo customerOrderRepo;

    @Autowired
    public CustomerOrderService(CustomerOrderRepo customerOrderRepo) {
        this.customerOrderRepo = customerOrderRepo;
    }

    @Override
    public List<CustomerOrder> findALl() {
        return customerOrderRepo.findAll();
    }

    @Override
    public CustomerOrder findById(Long id) {
        return customerOrderRepo.findById(id).get();
    }

    @Override
    public void save(CustomerOrder vo) {
        customerOrderRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        customerOrderRepo.deleteById(id);
    }
}
