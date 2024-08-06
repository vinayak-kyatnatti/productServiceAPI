package com.example.productservice.services;

import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductdServiceDBIMPl implements ProductService{
   public Product createProduct(Product product){
        return null;

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product partialUpdateProduct(Long productId,Product product) {
        return null;
    }
}
