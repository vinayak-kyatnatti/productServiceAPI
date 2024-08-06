package com.example.productservice.dtos.products;

import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private String categoryName;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageURL(this.imageURL);
        product.setCategoryName(this.categoryName);

        return product;
    }


}
