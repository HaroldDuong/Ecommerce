package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.Category;
import com.mock.ecommerce.repo.CategoryRepo;
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
public class CategoryService implements DAO<Category> {


    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public List<Category> findALl() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public void save(Category vo) {
        categoryRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
//commit
