package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * author: CuongTTC
 * */
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {


}
