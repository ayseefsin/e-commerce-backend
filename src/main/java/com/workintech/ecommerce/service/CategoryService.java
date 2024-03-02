package com.workintech.ecommerce.service;


import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Product;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category save(Category category);

    Category deleteCategory(Category category);


}
