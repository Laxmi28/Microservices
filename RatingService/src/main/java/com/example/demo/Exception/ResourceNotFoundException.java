package com.example.demo.Exception;

public class ResourceNotFoundException  extends RuntimeException{
     
    public ResourceNotFoundException(){
        super("No data found for this on server !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
