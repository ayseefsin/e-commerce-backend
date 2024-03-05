package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    private  ProductService productService;
    @Mock
    private  ProductRepository productRepository;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        ProductService productService = new ProductServiceImpl(productRepository,categoryService);
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getProductById() {
    }

    @Test
    void save() {
        Product product = new Product();
        product.setCategory(categoryService.getCategoryById(1L));
        product.setName("mock product");
        productService.save(product);
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void getProductsByCategory() {
    }

    @Test
    void getProductsByName() {
    }
}