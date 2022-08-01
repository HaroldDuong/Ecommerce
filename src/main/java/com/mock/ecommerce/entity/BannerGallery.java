package com.mock.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/*
 * author : CuongTTC
 * */

@Entity
@Table(name = "banner_gallery")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BannerGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
}
