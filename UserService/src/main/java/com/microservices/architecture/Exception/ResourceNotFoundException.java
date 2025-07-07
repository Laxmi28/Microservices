package com.microservices.architecture.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("No Data found on the server for this!!");
    }

     public ResourceNotFoundException(String message){
        super(message);
    }

}
