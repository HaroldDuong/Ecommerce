package com.mock.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "products")
public class ProductsEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    private Boolean enabled;

    private Double price;

    private String productColor;

    private String productName;

    private int stockQuantity;

    @UpdateTimestamp
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private BrandsEntity brands;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CategoriesEntity categories;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TypesEntity types;

    @OneToMany(mappedBy = "products")
    Set<RatesEntity> ratesEntitySet;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<CartItemEntity> cartItemEntities;

    @ManyToMany
    Set<ImageGalleryEntity> imageGalleryEntities;

}
