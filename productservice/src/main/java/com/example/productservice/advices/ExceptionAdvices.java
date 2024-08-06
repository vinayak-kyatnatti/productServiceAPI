package com.example.productservice.advices;

import com.example.productservice.dtos.products.ErrorResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvices {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRuntimeException(RuntimeException e){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto();
        errorResponseDto.setStatus("ERROR!");
        errorResponseDto.setMessage(e.getMessage());
        return errorResponseDto;
    }

    @ExceptionHandler(Exception.class)
    public String handleException(){
        return "Something went Wrong";
    }
}
