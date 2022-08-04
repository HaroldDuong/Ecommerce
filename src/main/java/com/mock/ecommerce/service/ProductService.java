package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.Product;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author CuongTTC
 */
@Service
@Transactional
public class ProductService implements DAO<Product> {


    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public List<Product> findALl() {
        return  productRepo.findAll().stream().filter(p->p.isEnabled() == true).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void save(Product vo) {
        productRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> findByCategoryId(Long categoryId) {
        return productRepo.findByCategoryId(categoryId).stream().filter(p->p.isEnabled() == true).collect(Collectors.toList());
    }

//    public List<Product> findByCategoryIdAndBrandId(Long categoryId, Long brandId) {
//        return productRepo.findByCategoryIdAndBrandId(categoryId, brandId).stream().filter(p->p.isEnabled() == true).collect(Collectors.toList());
//    }

//    public List<Product> findByCategoryIdAndTypeId(Long categoryId, Long typeId) {
//        return repofindByCategoryIdAndTypeId(categoryId, typeId).stream().filter(p->p.isEnabled() == true).collect(Collectors.toList());
//    }

//    public List<Product> findByBrandId(Long brandId) {
//        return repofindByBrandId(brandId).stream().filter(p->p.isEnabled() == true).collect(Collectors.toList());
//    }

//    public List<Product> findByTypeName(String typeName) {
//        return repofindByTypeName(typeName).stream().filter(p->p.isEnabled() == true).collect(Collectors.toList());
//    }

//    public List<Product> findByPriceBetween(Double min, Double max) {
//        return repofindByPriceBetween(min, max).stream().filter(p->p.isEnabled() == true).collect(Collectors.toList());
//    }

//    public List<Product> findByProductName(String productName) {
//        return repofindByProductNameContains(productName).stream().filter(p->p.isEnabled() == true).collect(Collectors.toList());
//    }


//    public List<Product> findByProductNameAndCategoryId(String productName,Long categoryId) {
//        return repofindByProductNameContainsAndAndCategoryId(productName, categoryId).stream().filter(p->p.isEnabled() == true).collect(Collectors.toList());
//    }

//    public List<Product> findAllIgnoreStatus(){
//        return repofindAll();
//    }

//    public List<Long> findTop5(){
//		Calendar c = Calendar.getInstance();
//		int month = c.get(Calendar.MONTH) + 1;
//		int year = c.get(Calendar.YEAR);
//        return repofindTop5(month, year);
//    }
//
//    public List<Product> findProductContains(String keyword){
//        return repofindProductContains(keyword);
//    }
//    public List<Product> findProductContainsByCategoryId(String keyword, Long categoryId){
//        return repofindProductContainsByCategory(keyword,categoryId);
//    }

}
