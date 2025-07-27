package com.example.demo.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
         ApiResponse apiResponse = ApiResponse.builder()
                                  .statusCode(HttpStatus.NOT_FOUND)
                                  .success(true)
                                  .message(exception.toString()).build();

        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);                          


    }

}
