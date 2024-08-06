package com.example.productservice.services;

import com.example.productservice.dtos.fakeStore.FakeStoreCreateProductRequestDto;
import com.example.productservice.dtos.fakeStore.FakeStoreGetProductResponseDto;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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


        return response.toProduct();

    }

    @Override
    public List<Product> getAllProducts() {
        throw new RuntimeException();

//        FakeStoreGetProductResponseDto[] response=restTemplate.getForObject(
//             "https://fakestoreapi.com/products",
//                FakeStoreGetProductResponseDto[].class
//        );
//
//        List<FakeStoreGetProductResponseDto>responseDtoList=
//                Stream.of(response).toList();
//
//        List<Product>products=new ArrayList<>();
//
//        for(FakeStoreGetProductResponseDto fakeStoreGetProductResponseDto:responseDtoList){
//            products.add(fakeStoreGetProductResponseDto.toProduct());
//        }
//        return products;
    }

    @Override
    public Product partialUpdateProduct(Long productId,Product product) {
        FakeStoreGetProductResponseDto productResponseDto= restTemplate.patchForObject(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreCreateProductRequestDto.fromProduct(product),
                FakeStoreGetProductResponseDto.class
        );
        return productResponseDto.toProduct();
    }

}
