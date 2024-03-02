package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.service.CategoryService;
import com.workintech.ecommerce.service.ProductService;
import com.workintech.ecommerce.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    @GetMapping
    public List<ProductResponse> getAllProducts(){
       List<Product> products= productService.getAllProducts();
       return Converter.convertProductList(products);
    }
    @GetMapping("/{categoryId}")
    public List<ProductResponse> getProductsByCategoryId(@PathVariable long categoryId){
        List<Product> categoryProducts = productService.getProductsByCategory(categoryId);
        return Converter.convertProductList(categoryProducts);
    }

    @PostMapping("/{categoryId}")
    public ProductResponse save(@RequestBody Product product , @PathVariable long categoryId){
        Category category = categoryService.getCategoryById(categoryId);
        category.addProduct(product);
        product.setCategory(category);
        productService.save(product);
        return new ProductResponse(product.getName());
    }

}
