package com.example.productservice.dtos.fakeStore;

import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreGetProductResponseDto {
    private Long id;
    private String description;
    private String image;
    private String category;
    private String price;
    private String title;

    public Product toProduct() {
        Product product1=new Product();
        product1.setTitle(this.getTitle());
        product1.setDescription(this.getDescription());
        product1.setPrice(Double.parseDouble(this.getPrice()));
        product1.setCategoryName(this.getCategory());
        product1.setImageURL(this.getImage());
        product1.setId(this.getId());

        return product1;
    }
}
