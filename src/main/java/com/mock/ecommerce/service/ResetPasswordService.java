package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.ResetPassword;
import com.mock.ecommerce.entity.User;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.ResetPasswordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author CuongTTC
 * */
@Service
@Transactional
public class ResetPasswordService implements DAO<ResetPassword> {
    private final ResetPasswordRepo resetPasswordRepo;

    @Autowired
    public ResetPasswordService(ResetPasswordRepo resetPasswordRepo) {
        this.resetPasswordRepo = resetPasswordRepo;
    }


    @Override
    public List<ResetPassword> findALl() {
        return resetPasswordRepo.findAll();
    }

    @Override
    public ResetPassword findById(Long id) {
        return resetPasswordRepo.findById(id).get();
    }

    @Override
    public void save(ResetPassword vo) {
        resetPasswordRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        resetPasswordRepo.deleteById(id);
    }

    public ResetPassword findByUser(User user){
        return resetPasswordRepo.findByUser(user);
    }

    public ResetPassword findByResetToken(String token){
        return resetPasswordRepo.findByResetToken(token);
    }

}
