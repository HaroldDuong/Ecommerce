package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * author CuongTTC
 * */
@Repository
public interface BrandRepo extends JpaRepository<Brand, Long> {
    List<Brand> findByNameContains(String brandName);
}
