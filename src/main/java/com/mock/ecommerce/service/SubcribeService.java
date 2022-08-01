package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.EmailSubcriber;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.SubcriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * author CuongTTC
 * */
@Service
@Transactional
public class SubcribeService implements DAO<EmailSubcriber> {

    private final SubcriberRepo subcriberRepo;

    @Autowired
    public SubcribeService(SubcriberRepo subcriberRepo) {
        this.subcriberRepo = subcriberRepo;
    }


    @Override
    public List<EmailSubcriber> findALl() {

        return subcriberRepo.findAll();
    }

    @Override
    public EmailSubcriber findById(Long id) {

        return subcriberRepo.findById(id).get();
    }

    @Override
    public void save(EmailSubcriber vo) {
        subcriberRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        subcriberRepo.deleteById(id);
    }

    public Long countByEmail(String email){
        return subcriberRepo.countByEmail(email);
    }
}
