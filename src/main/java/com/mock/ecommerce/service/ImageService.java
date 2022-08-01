package com.mock.ecommerce.service;

import com.mock.ecommerce.entity.ImageGallery;
import com.mock.ecommerce.repo.DAO;
import com.mock.ecommerce.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
*  Author: CuongTTC
* */
@Service
@Transactional
public class ImageService implements DAO<ImageGallery> {

    private final ImageRepo imageRepo;

    @Autowired
    public ImageService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }


    @Override
    public List<ImageGallery> findALl() {
        return imageRepo.findAll();
    }

    @Override
    public ImageGallery findById(Long id) {
        return imageRepo.findById(id).get();
    }

    @Override
    public void save(ImageGallery vo) {
        imageRepo.save(vo);
    }

    @Override
    public void delete(Long id) {
        imageRepo.deleteById(id);
    }
}
