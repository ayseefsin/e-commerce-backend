package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product save(Product product);

    Product deleteProduct(Product product);

    List<Product> getProductsByCategory(long categoryId);
    List<Product> getProductsByName(String name);
}
