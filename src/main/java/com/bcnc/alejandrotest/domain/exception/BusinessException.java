package com.bcnc.alejandrotest.domain.exception;

/**
 * This exception class is used to contain an exception in controlled process.
 * 
 * @author Alejandro Martin Marques
 */
public class BusinessException extends RuntimeException{
    
   private String errorMessage = "Some business error was produced";

    @Override
    public String getMessage(){
        return this.errorMessage;
    }
}
