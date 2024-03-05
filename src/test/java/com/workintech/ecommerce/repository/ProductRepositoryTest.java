package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;



    @Autowired
    public ProductRepositoryTest(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @DisplayName("getProductsByCategory method runs successfully")
    @Test
    void getProductsByCategory() {
       List<Product> products = productRepository.getProductsByCategory(categoryRepository.findById(1L).get());
       assertNotNull(products);
       assertEquals(products.size(),2);
    }
    @DisplayName("getProductsByName method runs successfully")
    @Test
    void getProductsByName() {
      List<Product> products = productRepository.getProductsByName("lue");
      assertNotNull(products);
      assertEquals(products.size(),1);
    }
}