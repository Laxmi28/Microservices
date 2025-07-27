package com.example.demo.Exception;

import org.springframework.http.HttpStatusCode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ApiResponse {

    private String message;
    private HttpStatusCode statusCode;
    private Boolean success;



}
