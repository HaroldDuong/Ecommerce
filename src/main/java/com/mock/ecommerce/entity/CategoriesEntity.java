package com.mock.ecommerce.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Entity
@Table(name = "categories")
public class CategoriesEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private Boolean enabled;

    private  String name;

    @UpdateTimestamp
    private LocalDateTime updated;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<TypesEntity> typesEntities;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<ProductsEntity> productsEntities;

}
