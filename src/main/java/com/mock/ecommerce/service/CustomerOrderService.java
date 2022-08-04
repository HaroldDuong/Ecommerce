package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.*;
import com.mock.ecommerce.repo.CustomerOrderRepo;
import com.mock.ecommerce.repo.DAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author CuongTTC
 */
@Service
@Transactional
@Slf4j
public class CustomerOrderService implements DAO<CustomerOrder> {


    private final CustomerOrderRepo customerOrderRepo;
    private final Cart cart;
    private final ProductService productService;

    @Autowired
    public CustomerOrderService(CustomerOrderRepo customerOrderRepo, Cart cart, ProductService productService) {
        this.customerOrderRepo = customerOrderRepo;
        this.cart = cart;
        this.productService = productService;
    }

    @Override
    public List<CustomerOrder> findALl() {
        return customerOrderRepo.findAll();
    }

    @Override
    public CustomerOrder findById(Long id) {
        return customerOrderRepo.findById(id).get();
    }

    @Override
    public void save(CustomerOrder vo) {
         customerOrderRepo.save(vo);
    }


    @Override
    public void delete(Long id) {
        customerOrderRepo.deleteById(id);
    }

//    public CustomerOrder findOrderByCustomerId(Long customerId) {
//        return customerOrderRepo.findTopOneCustomerIdOrderByOrderDateDesc(customerId);
//    }
//
//    public List<CustomerOrder> findAllOrderByCustomerId(Long customerId) {
//            return customerOrderRepo.findByCustomerIdOrderByOrderDateDesc(customerId);
//    }

    public CustomerOrder saveOrder(CustomerOrder vo){
        if (checkOrder(vo)){
            vo.getCartItems().forEach(cartItem -> {
                Product product = productService.findById(cartItem.getProduct().getId());
                if (isStockEqual(cartItem)){
                    log.info("decrease stock = 0 and set enable to false (out-stock)");
                    product.setStockQuantity(product.getStockQuantity()-cartItem.getSellingQuantity());
                    product.setEnabled(false);
                }else{
                    log.info("decrease stock");
                    product.setStockQuantity(product.getStockQuantity()-cartItem.getSellingQuantity());
                }
                productService.save(product);
            });
            log.info("save order");
            return customerOrderRepo.save(vo);
        }
        return null;
    }

    public CustomerOrder saveVO(CustomerOrder vo){
        return customerOrderRepo.save(vo);
    }

    private boolean checkOrder(CustomerOrder order){
        boolean check = true;
        for (CartItem cartItem: order.getCartItems()) {
            if (!checkStock(cartItem)){
                check = false;
                break;
            }
        }
        return check;
    }

    private boolean isStockEqual(CartItem item){
        Product product = productService.findById(item.getProduct().getId());
        if (item.getSellingQuantity() == product.getStockQuantity()){
            return true;
        }
        return false;
    }

    private boolean checkStock(CartItem item){
        Product product = productService.findById(item.getProduct().getId());
        if (item.getSellingQuantity()<= product.getStockQuantity()){
            return true;
        }
        return false;
    }
}
//commit
