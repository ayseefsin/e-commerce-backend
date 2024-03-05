package com.workintech.ecommerce.util;

import com.workintech.ecommerce.dto.ProductResponse;
import com.workintech.ecommerce.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<ProductResponse> convertProductList(List<Product> products){
        List< ProductResponse > productResponses=new ArrayList<>();
        for(Product product : products){
            productResponses.add(new ProductResponse(product.getName(), product.getImgUrl(), product.getPrice()));
        }
        return productResponses ;
    }

}
