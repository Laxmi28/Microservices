package com.example.microservices.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("No data exists!!");
    }

    public ResourceNotFoundException(String message){
         super(message);
    }

}
