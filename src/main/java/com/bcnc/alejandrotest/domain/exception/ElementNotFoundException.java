package com.bcnc.alejandrotest.domain.exception;

/**
 * This exception class is used to contain exception when some element is not finded.
 * 
 * @author Alejandro Martin Marques
 */
public class ElementNotFoundException extends RuntimeException{
    
   private String errorMessage = "Not found any element with your search";

    @Override
    public String getMessage(){
        return this.errorMessage;
    }
    
}
