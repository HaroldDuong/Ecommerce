package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.EmailSubscriber;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.SubscriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/***
 * author: CuongTTC
 * */
@Service
@Transactional
public class SubscriberService implements DAO<EmailSubscriber> {
    private final SubscriberRepo subscriberRepo;

    @Autowired
    public SubscriberService(SubscriberRepo subscriberRepo) {
        this.subscriberRepo = subscriberRepo;
    }

    @Override
    public List<EmailSubscriber> findALl() {
        return subscriberRepo.findAll();
    }

    @Override
    public EmailSubscriber findById(Long id) {
        // TODO Auto-generated method stub
        return subscriberRepo.findById(id).get();
    }

    @Override
    public void save(EmailSubscriber vo) {
        // TODO Auto-generated method stub
        subscriberRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        subscriberRepo.deleteById(id);
    }

    public Long countByEmail(String email) {
        return subscriberRepo.countByEmail(email);
    }


}
