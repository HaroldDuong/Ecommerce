package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.Brand;
import com.mock.ecommerce.repo.BrandRepo;
import com.mock.ecommerce.repo.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author: CuongTTC
 * */
@Service
@Transactional
public class BrandService implements DAO<Brand> {

    private final BrandRepo brandRepo;

    @Autowired
    public BrandService(BrandRepo brandRepo) {
        this.brandRepo = brandRepo;
    }


    @Override
    public List<Brand> findALl() {
        return brandRepo.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return brandRepo.findById(id).get();
    }

    @Override
    public void save(Brand vo) {
        brandRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        brandRepo.deleteById(id);
    }

    public List<Brand> findByNameContains(String brandName){
        return brandRepo.findByNameContains(brandName);
    }

}
//commit
