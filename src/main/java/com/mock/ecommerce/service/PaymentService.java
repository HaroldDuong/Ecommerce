package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.Payment;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * author: CuongTTC
 * */

@Service
@Transactional
public class PaymentService implements DAO<Payment> {

    private final PaymentRepo paymentRepo;

    @Autowired
    public PaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public List<Payment> findALl() {
        return null;
    }

    @Override
    public Payment findById(Long id) {
        return null;
    }

    @Override
    public void save(Payment vo) {

    }

    @Override
    public void delete(Long id) {

    }
}
