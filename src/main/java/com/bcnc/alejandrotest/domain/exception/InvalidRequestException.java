package com.bcnc.alejandrotest.domain.exception;

public class InvalidRequestException extends RuntimeException{
    
    private String errorMessage = "Bad request: ";
 
    public InvalidRequestException(String message){
        this.errorMessage = this.errorMessage + message;
    }

    @Override
    public String getMessage(){
        return this.errorMessage;
    }
     
 }
 