package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.Type;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * author CuongTTC
 * */

@Service
@Transactional
public class TypeService implements DAO<Type> {

    public final TypeRepo typeRepo;

    @Autowired
    public TypeService(TypeRepo typeRepo) {
        this.typeRepo = typeRepo;
    }


    @Override
    public List<Type> findALl() {
        return typeRepo.findAll() ;
    }

    @Override
    public Type findById(Long id) {
        return typeRepo.findById(id).get();
    }

    @Override
    public void save(Type vo) {
        typeRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        typeRepo.deleteById(id);
    }

    public List<Type> findByCategoryId(Long id){
        return typeRepo.findByCategoryId(id);
    }
}
