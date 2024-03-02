package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.exception.ApiException;
import com.workintech.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElseThrow(()->new ApiException("invalid id!", HttpStatus.NOT_FOUND));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Product product) {
        productRepository.delete(product);
        return product;
    }

    @Override
    public List<Product> getProductsByCategory(long categoryId) {
        return productRepository.getProductsByCategory(categoryService.getCategoryById(categoryId));
    }


}
