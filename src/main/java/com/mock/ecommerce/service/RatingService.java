package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.Product;
import com.mock.ecommerce.entity.Rating;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*  author: CuongTTC
* */

@Service
@Transactional
public class RatingService implements DAO<Rating> {

    private final RatingRepo ratingRepo;

    @Autowired
    public RatingService(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }


    @Override
    public List<Rating> findALl() {
        return ratingRepo.findAll();
    }

    @Override
    public Rating findById(Long id) {
        return ratingRepo.findById(id).get();
    }

    @Override
    public void save(Rating vo) {
        ratingRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        ratingRepo.deleteById(id);
    }


    public Rating findCustomerIdAndProductId(Long customerId, Long productId){
        return ratingRepo.findByCustomerIdAndProductId(customerId, productId);
    }

    public Double avgStarByProductId(Long productId){
        return ratingRepo.avgStarByProductId(productId);
    }

    public Integer countReviewByProductId(Long productId){
        return ratingRepo.countReviewByProductId(productId);
    }

    public Long percentOfStar(Long productId, Integer starNumber){
        Double numberReview = (double)ratingRepo.countReviewByProductIdAndStarNumber(productId, starNumber);
        Double totaleReview = (double)ratingRepo.countReviewByProductId(productId);

        Double result = (numberReview / totaleReview) * 100;

        return Math.round(result);
    }

    public Integer countReviewByProductIdAndStarNumber(Long productId, Integer starNumber){
        return ratingRepo.countReviewByProductIdAndStarNumber(productId, starNumber);
    }

    public Map<Long, Integer> findAllReviewByList(List<Product> listProduct){
        Map<Long, Integer> map = new HashMap<Long, Integer>();

        for(Product p : listProduct){
            map.put(p.getId(), ratingRepo.countReviewByProductId(p.getId()));
        }

        return map;
    }

    public Map<Long, Double> findAllAvgStarByList(List<Product> prooductList){
        Map<Long, Double> map = new HashMap<Long, Double>();

        for(Product p: prooductList){
            map.put(p.getId(), ratingRepo.avgStarByProductId(p.getId()));
        }

        return map;
    }


}
