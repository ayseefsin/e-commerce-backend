package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.CategoryResponse;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for(Category category : categories ){
            categoryResponses.add(new CategoryResponse(category.getName()));
        }
      return  categoryResponses;
    }
    @GetMapping("/{category_id}")
    public CategoryResponse getCategoryById(@PathVariable long category_id){
       Category category=categoryService.getCategoryById(category_id);
       return new CategoryResponse(category.getName());
    }

    @PostMapping
    public CategoryResponse save(@RequestBody Category category){

         categoryService.save(category);
        return new CategoryResponse(category.getName());
    }
    @PutMapping("{categoryId}")
    public CategoryResponse updateCategory(@PathVariable long categoryId, @RequestBody Category category){
       Category foundCategory= categoryService.getCategoryById(categoryId);
       foundCategory.setName(category.getName());
       foundCategory.setImgUrl(category.getImgUrl());
       foundCategory.setProductList(category.getProductList());
       categoryService.save(foundCategory);
        return new CategoryResponse(foundCategory.getName());

    }

    @DeleteMapping("/{categoryId}")
    public CategoryResponse deleteCategory(@PathVariable long categoryId){
        Category foundCategory= categoryService.getCategoryById(categoryId);
        categoryService.deleteCategory(foundCategory);
      return new CategoryResponse(foundCategory.getName()) ;
    }

}
