package com.workintech.ecommerce.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.service.CategoryService;
import com.workintech.ecommerce.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {

    private ProductService productService;



    private CategoryService categoryService;

    private ProductController productController;
    @Autowired
    public ProductControllerTest(ProductService productService, CategoryService categoryService, ProductController productController) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.productController = productController;
    }

    @DisplayName("getAllProducts() runs successfully")
    @Test
    void getAllProducts() {
       List<Product> products= productService.getAllProducts();
       assertNotNull(products);
       assertEquals(products.size(),4);
    }

    @Test
    void getProductsByCategoryId() {
        List<ProductResponse> productResponses=productController.getProductsByCategoryId(1);
        assertNotNull(productResponses);
        assertEquals(productResponses.size(),2);

    }
    @DisplayName("getProductsByName runs successfully")
    @Test
    void getProductsByName() {
        List<ProductResponse> productResponses=productController.getProductsByName("lue");
        assertNotNull(productResponses);
       assertEquals(productResponses.size(),1);
    }


    @Test
    void updateProductCategory() {
    }

    @Test
    void deleteProductById() {
    }
}