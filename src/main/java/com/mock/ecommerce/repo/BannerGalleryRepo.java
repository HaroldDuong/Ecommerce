package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.BannerGallery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * author CuongTTC
 * */

@Repository
public interface BannerGalleryRepo extends JpaRepository<BannerGallery, Long> {
}
