package com.example.microservices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEntityNotFoundException(ResourceNotFoundException exception){

         ApiResponse apiResponse = ApiResponse.builder()
                                    .status(HttpStatus.NOT_FOUND)
                                    .message(exception.getMessage())
                                    .success(true).build();
          return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);                            

    }



}
