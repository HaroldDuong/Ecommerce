package com.mock.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "image_gallery")
public class ImageGalleryEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Lob
    @Column(name = "image", columnDefinition="LONGBLOB")
    private byte[] image;

}
