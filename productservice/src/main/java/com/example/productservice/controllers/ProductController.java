package com.example.productservice.controllers;

import com.example.productservice.dtos.products.*;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public GetAllProductResponseDto getAllProducts(){
        List<Product> products=productService.getAllProducts();
        GetAllProductResponseDto response=new GetAllProductResponseDto();


        List<GetProductDto> getProductResponseDtos=new ArrayList<>();

        for(Product product:products){
            getProductResponseDtos.add(GetProductDto.from(product));
        }
        response.setProducts(getProductResponseDtos);
       return response;
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable Long id){
        return "Here is your product "+id;
    }

    @DeleteMapping("/{id}")
    public void deleteSingleProduct(@PathVariable Long id){
        // Implementation code here
    }

    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(@PathVariable("id")Long productId,@RequestBody CreateProductDto productDto){
        Product product=productService.partialUpdateProduct(
                productId,productDto.toProduct()
        );
        PatchProductResponseDto response=new PatchProductResponseDto();
        response.setProduct(GetProductDto.from(product));
        return response;
    }

    @PutMapping("")
    public void replaceProduct(){}

    @GetMapping("/magic")
    public String manisi(){
        return "magic";
    }

}
