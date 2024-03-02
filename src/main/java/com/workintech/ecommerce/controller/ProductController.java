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
    @GetMapping("/name/{name}")
    public List<ProductResponse> getProductsByName(@PathVariable String name){
        List<Product> products= productService.getProductsByName(name);
        return Converter.convertProductList(products);
    }

    @PostMapping("/{categoryId}")
    public ProductResponse save(@RequestBody Product product , @PathVariable long categoryId){
        Category category = categoryService.getCategoryById(categoryId);
        category.addProduct(product);
        product.setCategory(category);
        productService.save(product);
        return new ProductResponse(product.getName());
    }
    @PutMapping("/{categoryId}")
    public ProductResponse updateProductCategory(@PathVariable long categoryId, @RequestBody Product product){
       Product foundproduct =  productService.getProductById(product.getId());
       foundproduct.setCategory(categoryService.getCategoryById(categoryId));
       productService.save(foundproduct);
       return new ProductResponse(foundproduct.getName());
    }
    @DeleteMapping("/{productId}")
    public ProductResponse deleteProductById(@PathVariable long productId){
        Product foundProduct = productService.getProductById(productId);
        productService.deleteProduct(foundProduct);
        return new ProductResponse(foundProduct.getName());
    }


}
