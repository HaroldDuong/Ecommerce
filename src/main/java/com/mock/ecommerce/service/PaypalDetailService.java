package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.PaypalDetail;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.PaymentDetailRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author CuongTTC
 */
@Service
@Transactional
public class PaypalDetailService implements DAO<PaypalDetail> {


    private final PaymentDetailRepo paymentDetailRepo;

    public PaypalDetailService(PaymentDetailRepo paymentDetailRepo) {
        this.paymentDetailRepo = paymentDetailRepo;
    }



    @Override
    public List<PaypalDetail> findALl() {
        return paymentDetailRepo.findAll();
    }

    @Override
    public PaypalDetail findById(Long id) {
        return paymentDetailRepo.findById(id).get();
    }

    @Override
    public void save(PaypalDetail vo) {
        paymentDetailRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        paymentDetailRepo.deleteById(id);
    }




}
//commit