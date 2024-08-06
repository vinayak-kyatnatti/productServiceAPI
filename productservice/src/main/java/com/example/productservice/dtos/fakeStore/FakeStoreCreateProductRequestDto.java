package com.example.productservice.dtos.fakeStore;

import com.example.productservice.models.Product;
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

    public static FakeStoreCreateProductRequestDto fromProduct(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto = new FakeStoreCreateProductRequestDto();
        fakeStoreCreateProductRequestDto.title = product.getTitle();
        fakeStoreCreateProductRequestDto.description = product.getDescription();
        fakeStoreCreateProductRequestDto.price = product.getPrice();
        fakeStoreCreateProductRequestDto.category=product.getCategoryName();
        fakeStoreCreateProductRequestDto.imageUrl= product.getImageURL();

        return fakeStoreCreateProductRequestDto;

    }

}
