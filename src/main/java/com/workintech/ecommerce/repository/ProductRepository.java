package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.dto.CategoryResponse;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT p FROM Product p WHERE p.category = :category" )
    List<Product> getProductsByCategory(Category category);

    @Query(value = "SELECT p FROM Product p WHERE p.name ILIKE %:name%")
    List<Product> getProductsByName(String name);
}
