package com.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreCreateProductRequestDto {
    private String name;
    private String description;
    private String title;
    private double price;
    private String imageUrl;
    private String category;

}
