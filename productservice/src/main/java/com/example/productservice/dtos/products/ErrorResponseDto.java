package com.example.productservice.dtos.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    public String message;
    public String status;

}
