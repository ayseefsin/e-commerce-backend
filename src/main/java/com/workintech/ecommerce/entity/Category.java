package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "category", schema = "e-commerce")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "img_url")
    private String imgUrl;

    @Size(min = 3  , max = 20 , message = "name must be name between 3 and 20 characters")
    private String name;

    @OneToMany(mappedBy="category", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Product> productList;

    public  void addProduct(Product product){
        if(productList == null){
         productList = new ArrayList<>();
        }
        productList.add(product);
    }
}
