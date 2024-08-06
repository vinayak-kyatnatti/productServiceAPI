package com.example.productservice.dtos.products;

import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDto {
    private Long id;
    private String description;
    private String title;
    private double price;
    private String imageUrl;

    public static GetProductDto from(Product product) {
        GetProductDto getProductResponseDto = new GetProductDto();
        getProductResponseDto.setId(product.getId());
        getProductResponseDto.setDescription(product.getDescription());
        getProductResponseDto.setTitle(product.getTitle());
        getProductResponseDto.setPrice(product.getPrice());
        getProductResponseDto.setImageUrl(product.getImageURL());

        return getProductResponseDto;
    }
}
