package com.mock.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * author: CuongTTC
 * */

@Entity
@Table(name = "image_gallery")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ImageGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "LONGLOB")
    private byte[] image;


}
