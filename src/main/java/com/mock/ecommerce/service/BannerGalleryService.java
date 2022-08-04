package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.BannerGallery;
import com.mock.ecommerce.repo.BannerGalleryRepo;
import com.mock.ecommerce.repo.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
* author : CuongTTC
* */
@Service
@Transactional
public class BannerGalleryService implements DAO<BannerGallery> {
	private final BannerGalleryRepo bannerGalleryRepo;

	@Autowired
	public BannerGalleryService(BannerGalleryRepo bannerGalleryRepo) {
		this.bannerGalleryRepo = bannerGalleryRepo;
	}


	@Override
	public List<BannerGallery> findALl() {
		return bannerGalleryRepo.findAll();
	}

	@Override
	public BannerGallery findById(Long id) {
		return bannerGalleryRepo.getOne(id);
	}

	@Override
	public void save(BannerGallery vo) {
		bannerGalleryRepo.save(vo);
		
	}

	@Override
	public void delete(Long id) {
		bannerGalleryRepo.deleteById(id);
	}

}
