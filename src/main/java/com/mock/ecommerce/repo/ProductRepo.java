package com.mock.ecommerce.repo;

import com.mock.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: CuongTTC
 * */
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
     List<Product> findByCategoryId(Long categoryId);
     List<Product> findByBrandId(Long brandId);
     List<Product> findByTypeName(String typeName);
     List<Product> findByCategoryAndBrandId(Long categoryId, Long brandId);
     List<Product> findByCategoryAndTypeId(Long categoryId, Long typeId);
     List<Product> findByPriceBetween(Double min, Double max);
     List<Product> findByProductContains(String keyword);
     List<Product> findByProductNameContainsAndCategoryId(String productName, Long categoryId);


     @Query(value = "SELECT ca.product_id " +
                    "FROM payments p " +
                    "INNER JOIN customer_order_cart_items c ON c.customer_order_id = p.customer_order_id " +
                    "INNER JOIN cart_item ca ON c.cart_items_id = ca.id " +
                    "WHERE p.status= true " +
                    "AND MONTH(p.payment_date) = ?1 AND YEAR(p.payment_date) = ?2 " +
                    "GROUP BY ca.product " +
                    "ORDER BY sum(ca.selling_quantity) " +
                    "DESC LIMIT 5", nativeQuery = true)
     List<Product> findTop5(int month, int year);

     @Query(value = "SELECT * FROM products p " +
             "LEFT JOIN brands b ON p.brand_id = b_id " +
             "LEFT JOIN types t ON p.type_id = t.id " +
             "WHERE p.product_name LIKE %:keyword% " +
             "OR b.name LIKE %:keyword% " +
             "OR t.name LIKE %:keyword% " +
             "GROUP BY p.id " +
             "HAVING p.category_id = :id " +
             "and p.enabled = true ", nativeQuery = true)
     List<Product> findProductContainsByCategory(@Param("keyword") String keyword , @Param("id") Long categoryId);



     @Query(value = "SELECT * FROM products p " +
             "LEFT JOIN brands b on p.brand_id = b.id " +
             "LEFT JOIN categories c ON p.category_id = c.id " +
             "LEFT JOIN types t ON p.type_id = t.id " +
             "WHERE p.product_name LIKE %:keyword% " +
             "OR b.name LIKE %:keyword% " +
             "OR c.name LIKE %:keyword% " +
             "OR t.name LIKE %:keyword% " +
             "GROUP BY p.id " +
             "HAVING p.enable = true ",nativeQuery = true)
     List<Product> findProductContains(@Param("keyword") String keyword);
}
