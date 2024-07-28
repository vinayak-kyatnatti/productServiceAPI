package com.example.productservice.controllers;

import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.dtos.CreateProductResponseDto;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private  ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        Product product=productService.createProduct(
                createProductRequestDto.toProduct()
        );
        return CreateProductResponseDto.fromProduct(
                product
        );
//        return "This product is priced at: "+createProductRequestDto.getPrice();
    }

    @GetMapping("/")
    public void getAllProducts(){
        // Implementation code here
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable Long id){
        return "Here is your product "+id;
    }

    @DeleteMapping("/{id}")
    public void deleteSingleProduct(@PathVariable Long id){
        // Implementation code here
    }

    public void updateProduct(){}

    public void replaceProduct(){}

    @GetMapping("/magic")
    public String manisi(){
        return "magic";
    }
}
