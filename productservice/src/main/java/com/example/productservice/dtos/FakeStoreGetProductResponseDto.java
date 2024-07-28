package com.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreGetProductResponseDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String category;
    private String price;


}
