package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.Product;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  author CuongTTC
 * */

@Service
@Transactional
public class ProductService implements DAO<Product> {


    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> findALl() {
        return productRepo.findAll();
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

    public List<Product> findByCategoryId(Long categoryId){
        return productRepo.findByCategoryId(categoryId).stream().filter(product->product.isEnabled() == true).collect(Collectors.toList());
    }

    public List<Product> findByCategoryIdAndBrandId(Long categoryId, Long brandId){
        return productRepo.findByCategoryAndBrandId(categoryId, brandId).stream().filter(product->product.isEnabled() == true).collect(Collectors.toList());
    }

    public List<Product> findByCategoryIdAndTypeId(Long categoryId, Long typeId){
        return productRepo.findByCategoryAndTypeId(categoryId, typeId).stream().filter(product -> product.isEnabled() == true).collect(Collectors.toList());
    }

    public List<Product> findByBrandId(Long brandId){
        return productRepo.findByBrandId(brandId).stream().filter(product -> product.isEnabled() == true).collect(Collectors.toList());
    }

    public List<Product> findByTypeName(String typeName){
        return productRepo.findByTypeName(typeName).stream().filter(product -> product.isEnabled() == true).collect(Collectors.toList());
    }

    public List<Product> findByPriceBetween(Double min, Double max){
        return productRepo.findByPriceBetween(min, max).stream().filter(product -> product.isEnabled() == true).collect(Collectors.toList());
    }

    public List<Product> findByeProductName(String keyword){
        return productRepo.findProductContains(keyword).stream().filter(product -> product.isEnabled() == true).collect(Collectors.toList());
    }

    public List<Product> findByProductNameAndCategoryId(String productName,Long categoryId){
        return productRepo.findByProductNameContainsAndCategoryId(productName, categoryId).stream().filter(product -> product.isEnabled() == true).collect(Collectors.toList());
    }

    public List<Product> findAllIgnoreStatus(){
        return productRepo.findAll();
    }

    public List<Product> findTopFive(){
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);

        return productRepo.findTop5(month, year).stream().filter(product -> product.isEnabled() == true).collect(Collectors.toList());
    }

    public List<Product> findProductContains(String keyword){
        return productRepo.findProductContains(keyword).stream().filter(product -> product.isEnabled() == true).collect(Collectors.toList());
    }

    public List<Product> findProductContainsByCategoryId(String keyword, Long categoryId){
        return productRepo.findProductContainsByCategory(keyword, categoryId).stream().filter(product -> product.isEnabled() == true).collect(Collectors.toList());
    }




}
