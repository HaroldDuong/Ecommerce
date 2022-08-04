package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.*;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.PaymentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * author CuongTTC
 */
@Service
@Transactional
@Slf4j
public class PaymentService implements DAO<Payment> {


	private final PaymentRepo paymentRepo;
	private final ProductService productService;

	@Autowired
	public PaymentService(PaymentRepo paymentRepo, com.mock.ecommerce.service.ProductService productService) {
		this.paymentRepo = paymentRepo;
		this.productService = productService;
	}


	@Override
	public List<Payment> findALl() {
		return paymentRepo.findAll();
	}

	@Override
	public Payment findById(Long id) {
		return paymentRepo.findById(id).get();
	}

	@Override
	public void save(Payment vo) {
		paymentRepo.save(vo);
	}



	@Override
	public void delete(Long id) {
		paymentRepo.deleteById(id);
	}

//	public Payment findPaymentByCustomerOrderId(Long customerOrderId) {
//		return paymentRepo.findTopOneByCustomerOrderByPaymentDateDesc(customerOrderId);
//	}
//
//	public Long countByCustomerOrderId(Long customerOrderId) {
//		return paymentRepo.countByCustomerOrderId(customerOrderId);
//	}

	public Double statistiqueSalesByMonthYear(int month, int year) {
		Double result = 0.0d;
		if(paymentRepo.totalPriceInPaymentByMonthYear(month, year) != null) {
			result = paymentRepo.totalPriceInPaymentByMonthYear(month, year);
		}
		return result;
	}

	public HashMap<Integer, Double> statistiqueSalesByYear(int year) {
		HashMap<Integer, Double> result = new HashMap<Integer, Double>();
		for (int i = 1; i <= 12; i++) {
			result.put(i, statistiqueSalesByMonthYear(i, year));
		}
		return result;
	}
	
	public List<Double> getListPricePayment(HashMap<Integer, Double> salesByYear){
		List<Double> list = new ArrayList<Double>();
		for (Integer m : salesByYear.keySet()) {
			list.add(salesByYear.get(m));
		}
		return list;
	}
	public double totalSales(HashMap<Integer, Double> salesByYear) {
		double totalSales = 0.0;
		for (Integer m : salesByYear.keySet()) {
			totalSales += salesByYear.get(m);
		}
		return totalSales;
	}
	
	public List<Payment> findAllPaymentByCustomerId(Long customerId){
		return paymentRepo.findAllByCustomerIdOrderPaymentDateDesc(customerId);
	}

	public void saveVO(Payment vo) {
		CustomerOrder order =  vo.getCustomerOrder();
		if (checkOrder(order)){
			order.getCartItems().forEach(cartItem -> {
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
			log.info("save Payment");
		}
		paymentRepo.save(vo);
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
