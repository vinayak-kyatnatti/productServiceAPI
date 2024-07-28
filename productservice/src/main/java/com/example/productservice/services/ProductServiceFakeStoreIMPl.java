package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreCreateProductRequestDto;
import com.example.productservice.dtos.FakeStoreGetProductResponseDto;
import com.example.productservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
//@Primary
public class ProductServiceFakeStoreIMPl implements ProductService{
    public RestTemplate restTemplate ;
    public ProductServiceFakeStoreIMPl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

   public Product createProduct(Product product){
       FakeStoreCreateProductRequestDto request= new FakeStoreCreateProductRequestDto();
       request.setTitle(product.getTitle());
       request.setDescription(product.getDescription());
       request.setPrice(product.getPrice());
       request.setCategory(product.getCategoryName());
       request.setImageUrl(product.getImageURL());

        FakeStoreGetProductResponseDto response= restTemplate.postForObject(
                "https://fakestoreapi.com/products", request, FakeStoreGetProductResponseDto.class);

        Product product1=new Product();
        product1.setTitle(product.getTitle());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setCategoryName(product.getCategoryName());
        product1.setImageURL(product.getImageURL());
        product1.setId(product1.getId());

        return product;

    }

}
