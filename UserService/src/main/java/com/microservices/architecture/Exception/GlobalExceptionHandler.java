package com.microservices.architecture.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){

        String msg = ex.getMessage();

        ApiResponse apiResponse = ApiResponse.builder()
                                .statusCode(HttpStatus.NOT_FOUND)
                                .success(true)
                                .message(msg).build();
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);                       


    } 

}
