package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.ImageGallery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
* author: CuongTTC
* */
@Repository
public interface ImageRepo extends JpaRepository<ImageGallery, Long> {


}
