package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.Customer;

import com.mock.ecommerce.repo.CustomerRepo;
import com.mock.ecommerce.repo.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author CuongTTC
 * */
@Service
@Transactional
public class CustomerService implements DAO<Customer> {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    @Override
    public List<Customer> findALl() {
        return customerRepo.findAll() ;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public void save(Customer vo) {
        customerRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        customerRepo.deleteById(id);
    }

    public Long countByUserId(Long userId){
        return customerRepo.countByUserId(userId);
    }

    public Customer findByUserId(Long userId){
        return customerRepo.findByUserId(userId);
    }

}
//commit
