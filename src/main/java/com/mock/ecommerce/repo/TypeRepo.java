package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author : CuongTTC
 * */
@Repository
public interface TypeRepo extends JpaRepository<Type, Long> {
    List<Type> findByCategoryId(Long id);

}